package com.news.service;

import com.news.model.News;

import java.util.List;

public interface NewsService {

    List<News> getAllNews();

    News getNewsById(Long id);

    void removeById(Long id);

    void save(News news);
}

