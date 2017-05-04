package com.news.service;

import java.util.List;

import com.news.model.News;
import com.news.model.NewsCategory;
import com.news.model.NewsStatus;

public interface SearchService {

  List<News> searchByCategory(NewsCategory newsCategory);

  List<News> searchByStatus(NewsStatus newsStatus);

  List<News> searchByTitle(String title);

  List<News> ifEnumExistFindNews(String text);

}
