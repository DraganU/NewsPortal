package com.news.service.impl;

import com.news.model.News;
import com.news.repository.NewsRepository;
import com.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsRepository newsRepository;

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNewsById(Long id) {
        return newsRepository.findOne(id);
    }

    @Transactional
    @Override
    public void removeById(Long id) {
        News news = newsRepository.findOne(id);
        if (news == null) {
            throw new IllegalArgumentException("Tried to remove nonexistant activity id:" + id);
        }
        news.setDeleted(true);
        newsRepository.save(news);
    }

    @Transactional
    @Override
    public void save(News news) {
        if (news.getId() == null) {
            news.setCreated(new Date());
            newsRepository.save(news);
        } else {
            newsRepository.save(news);
        }
    }
}
