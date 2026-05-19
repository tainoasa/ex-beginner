package com.example.ex_beginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {
    @GetMapping()
    public String index() {
        return "exam02";
    }

    @PostMapping("/show-result")
    public String showResult(int num1, int num2) {
        return "exam02-result";
    }
}
