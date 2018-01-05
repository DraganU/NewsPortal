package com.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.news.model.News;
import com.news.service.NewsService;

@RestController
@RequestMapping("news")
public class NewsController {

  @Autowired
  NewsService newsService;

  @GetMapping
  public ResponseEntity<List<News>> getAllNews() {
    return new ResponseEntity<>(newsService.getAllNews(), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<News> getNewsById(@PathVariable Long id) {
    return new ResponseEntity<>(newsService.getNewsById(id), HttpStatus.OK);
  }

  @DeleteMapping(value = "/remove/{id}")
  public ResponseEntity<News> deleteNews(@PathVariable Long id) {
      return new ResponseEntity<>(newsService.removeById(id), HttpStatus.OK);
  }

  @PostMapping(value = "/create")
  public ResponseEntity<News> addNews(@RequestBody News news) {
    return new ResponseEntity<>(newsService.save(news), HttpStatus.OK);
  }

}
