package com.kaydang.java.controller;

import com.kaydang.java.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Component
@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api")
public class RestController {

    @Autowired
    private RestService restService;

    @RequestMapping(value = "/getCategories", method = RequestMethod.GET)
    public Map<String, Long> getCategories() {
        return restService.getCategories();
    }

    @RequestMapping(value = "/getSpecialties", method = RequestMethod.GET)
    public Map<String, Long> getSpecialties() {
        return restService.getSpecialties();
    }

    @RequestMapping(value = "/getApplicationNames", method = RequestMethod.GET)
    public Map<String, Long> getApplicationNames() {
        return restService.getApplicationNames();
    }

}