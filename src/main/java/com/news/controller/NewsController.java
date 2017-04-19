package com.news.controller;

import com.news.model.News;
import com.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> getAllNews () {
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
            return new ResponseEntity<News>(news, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping (value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<News> addNews(@RequestBody News news) {
        newsService.save(news);
        return new ResponseEntity<News>(news, HttpStatus.OK);
    }

    // TODO change to service have return not like this...
    @PutMapping (value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<News> editNews(@RequestBody News news) {
        News newsPersistence = newsService.getNewsById(news.getId());
        if (newsPersistence != null ) {
            newsService.save(news);
            return new ResponseEntity<News>(news, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
