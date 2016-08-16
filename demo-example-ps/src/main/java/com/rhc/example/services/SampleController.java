package com.rhc.example.services;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by srang on 8/14/16.
 */
@RestController
@EnableAutoConfiguration
public class SampleController {
    private static Integer counter = 0;


    private static Integer nextId() {
       return counter++;
    }

    @RequestMapping("/{name}")
    @ResponseBody
    public String newClaim(@PathVariable("name") String name) {
        return name;
    }
}
