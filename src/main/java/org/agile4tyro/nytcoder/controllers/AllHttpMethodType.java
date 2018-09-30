package org.agile4tyro.nytcoder.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AllHttpMethodType {
    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }
}