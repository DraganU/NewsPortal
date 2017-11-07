package com.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

  @Autowired NewsService newsService;

  @GetMapping
  public ResponseEntity<List<News>> getAllNews() {
    List<News> newsList = newsService.getAllNews();
    return new ResponseEntity<>(newsList, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<News> getNewsById(@PathVariable Long id) {
    News news = newsService.getNewsById(id);
    return new ResponseEntity<>(news, HttpStatus.OK);
  }

  @DeleteMapping(value = "/remove/{id}")
  public ResponseEntity<News> deleteNews(@PathVariable Long id) {
    News news = newsService.getNewsById(id);
    if (news != null) {
      newsService.removeById(id);
      return new ResponseEntity<>(news, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.OK);
    }
  }

  @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<News> addNews(@RequestBody News news) {
    // Edit
    if (newsService.isNewsExist(news)) {
      return new ResponseEntity<>(newsService.save(news), HttpStatus.OK);
    // Add
    } else if ( news != null ) {
      return new ResponseEntity<>(newsService.save(news), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
