package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Arrays;

@RestController
public class Test {
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public List<String> list() {
        return Arrays.asList("Hello","World");
    }
}
