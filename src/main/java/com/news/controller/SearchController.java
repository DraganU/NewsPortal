package com.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.news.model.News;
import com.news.service.SearchService;

@RestController
@RequestMapping("search")
public class SearchController {

  @Autowired SearchService searchService;

  @GetMapping(value = "/category")
  public ResponseEntity<List<News>> searchByCategory(@RequestParam(value = "category") String category) {
    List<News> listOfNewsByCategory = searchService.ifEnumExistFindNews(category);
    if (!listOfNewsByCategory.isEmpty()) {
      return new ResponseEntity<>(listOfNewsByCategory, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping(value = "/status")
  public ResponseEntity<List<News>> searchByStatus(@RequestParam(value = "status") String status) {
    List<News> listOfNewsByStatus = searchService.ifEnumExistFindNews(status);
    if (!listOfNewsByStatus.isEmpty()){
      return new ResponseEntity<>(listOfNewsByStatus, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping(value = "/title")
  public ResponseEntity<List<News>> searchByTitle(@RequestParam(value = "title") String title) {
    List<News> listOfNewsByTitle = searchService.searchByTitle(title);
    if (!listOfNewsByTitle.isEmpty()) {
      return new ResponseEntity<>(listOfNewsByTitle, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

}
