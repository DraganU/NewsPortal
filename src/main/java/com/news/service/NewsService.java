package com.news.service;

import java.util.List;

import com.news.model.News;

public interface NewsService {

  List<News> getAllNews();

  News getNewsById(Long id);

  void removeById(Long id);

  News save(News news);

  boolean isNewsExist(News news);
}

