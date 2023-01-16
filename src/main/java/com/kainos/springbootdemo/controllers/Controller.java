package com.kainos.springbootdemo.controllers;

import com.kainos.springbootdemo.models.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class Controller {

    @GetMapping(path = "/")
    public @ResponseBody List<Resource> getResources() {
        log.info("No resources available");
        return new ArrayList<>();
    }
}

