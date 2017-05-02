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
    List<News> unDeleted = new ArrayList<>();
    for (News n : allNews) {
      if (!n.deleted) {
        unDeleted.add(n);
      }
    }
    return unDeleted;
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
  public void save(News news) {
    if (news.getId() == null) {
      news.setCreated(new Date());
      newsRepository.save(news);
    } else {
      newsRepository.save(news);
    }
  }
}
