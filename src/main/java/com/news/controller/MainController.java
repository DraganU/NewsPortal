package com.news.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"", "/", "home"})
public class MainController {

    @GetMapping
    public String getHelloWorld () {
        return "Hello Wolrd i molim te uradi mi HTML STRANICU";
    }
}
