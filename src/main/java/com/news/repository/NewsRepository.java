package com.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.news.model.News;
import com.news.model.NewsCategory;
import com.news.model.NewsStatus;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

  List<News> findAllByCategory(NewsCategory newsCategory);

  List<News> findAllByStatus(NewsStatus newsStatus);

  List<News> findByTitleContaining(String title);

}
