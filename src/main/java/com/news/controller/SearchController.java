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
  public ResponseEntity<List<News>> searchByCategory(@RequestParam String category) {
    return new ResponseEntity<>(searchService.ifEnumExistFindNews(category), HttpStatus.OK);
  }

  @GetMapping(value = "/status")
  public ResponseEntity<List<News>> searchByStatus(@RequestParam String status) {
    return new ResponseEntity<>(searchService.ifEnumExistFindNews(status), HttpStatus.OK);
  }

  @GetMapping(value = "/title")
  public ResponseEntity<List<News>> searchByTitle(@RequestParam String title) {
    return new ResponseEntity<>(searchService.searchByTitle(title), HttpStatus.OK);
  }

}
