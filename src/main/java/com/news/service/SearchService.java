package com.news.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.model.News;
import com.news.model.NewsCategory;
import com.news.model.NewsStatus;
import com.news.repository.NewsRepository;

@Service
public class SearchService {

  @Autowired
  NewsRepository newsRepository;

  private List<News> searchByCategory(NewsCategory newsCategory) {
    return newsRepository.findAllByCategoryAndDeleted(newsCategory, false);
  }

  private List<News> searchByStatus(NewsStatus newsStatus) {
    return newsRepository.findAllByStatusAndDeleted(newsStatus, false);
  }

  public List<News> searchByTitle(String title) {
    return newsRepository.findAllByTitleContainingAndDeleted(title, false);
  }

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
