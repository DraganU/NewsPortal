package com.news.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.news.controller.exceptions.EntityNotFoundException;
import com.news.model.News;
import com.news.repository.NewsRepository;

@Service
public class NewsService {

  @Autowired
  NewsRepository newsRepository;

  // Should also exist get all news deleted and unDeleted together for admin purposes.
  public List<News> getAllNews() {
    return newsRepository.findAllByDeleted(false);
  }

  public News getNewsById(Long id) {
    News news = newsRepository.findOne(id);
    if (news != null) {
      return newsRepository.findOne(id);
    } else {
      throw new EntityNotFoundException();
    }
  }

  @Transactional
  public News removeById(Long id) {
    News news = newsRepository.findOne(id);
    if (news != null) {
      news.setDeleted(true);
      return newsRepository.save(news);
    }
    throw new EntityNotFoundException();
  }

  // Save or edit
  @Transactional
  public News save(News news) {
    if (news.getId() == null) {
      news.setCreated(new Date());
      return newsRepository.save(news);
    } else {
      return newsRepository.save(news);
    }
  }

}
