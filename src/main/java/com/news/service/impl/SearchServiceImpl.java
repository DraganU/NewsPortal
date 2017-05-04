package com.news.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.model.News;
import com.news.model.NewsCategory;
import com.news.model.NewsStatus;
import com.news.repository.NewsRepository;
import com.news.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

  @Autowired NewsRepository newsRepository;

  @Override
  public List<News> searchByCategory(NewsCategory newsCategory) {
    return newsRepository.findAllByCategory(newsCategory);
  }

  @Override
  public List<News> searchByStatus(NewsStatus newsStatus) {
    return newsRepository.findAllByStatus(newsStatus);
  }

  @Override
  public List<News> searchByTitle(String title) {
    return newsRepository.findByTitleContaining(title);
  }

  @Override
  public List<News> ifEnumExistFindNews(String text) {
    for (NewsCategory nc : NewsCategory.values()) {
      if (nc.name().equals(text)) {
        return searchByCategory(nc);
      }
    }
    for (NewsStatus ns : NewsStatus.values()) {
      if (ns.name().equals(text)) {
        return searchByStatus(ns);
      }
    }
    return new ArrayList<>();
  }

}
