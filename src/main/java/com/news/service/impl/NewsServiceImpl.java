package com.news.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.news.model.News;
import com.news.repository.NewsRepository;
import com.news.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

  @Autowired NewsRepository newsRepository;

  @Override
  public List<News> getAllNews() {
    List<News> allNews = newsRepository.findAll();
    return withoutDeleted(allNews);
  }

  @Override
  public News getNewsById(Long id) {
    return newsRepository.findOne(id);
  }

  @Transactional
  @Override
  public void removeById(Long id) {
    News news = newsRepository.findOne(id);
    if (news == null) {
      throw new IllegalArgumentException("Tried to remove nonexistant activity id:" + id);
    }
    news.setDeleted(true);
    newsRepository.save(news);
  }

  @Transactional
  @Override
  public News save(News news) {
    if (news.getId() == null) {
      news.setCreated(new Date());
      return newsRepository.save(news);
    } else {
      return newsRepository.save(news);
    }
  }

  @Override
  public boolean isNewsExist(News news) {
    if (news != null && news.getId() != null) {
      if (newsRepository.findOne(news.getId()) != null) {
        return true;
      }
    }
    return false;
  }

  private List<News> withoutDeleted(List<News> allFoundedNews) {
    List<News> unDeleted = new ArrayList<>();
    for (News news : allFoundedNews) {
      if (!news.deleted) {
        unDeleted.add(news);
      }
    }
    return unDeleted;
  }
}
