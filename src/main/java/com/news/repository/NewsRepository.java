package com.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.news.model.News;
import com.news.model.NewsCategory;
import com.news.model.NewsStatus;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

  List<News> findAllByDeleted(boolean deleted);

  List<News> findAllByCategoryAndDeleted(NewsCategory newsCategory, boolean deleted);

  List<News> findAllByStatusAndDeleted(NewsStatus newsStatus, boolean deleted);

  List<News> findAllByTitleContainingAndDeleted(String title, boolean deleted);

}