package com.example.ex_beginner.controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {
    @GetMapping()
    public String index() {
        return "exam03";
    }

    @Autowired
    private ServletContext application;

    @PostMapping("/show-result")
    public String showResult(int price1, int price2, int price3) {
        application.setAttribute("withoutTax", (price1 + price2 + price3));
        application.setAttribute("includeTax", (int) ((price1 + price2 + price3) * 1.1));

        return "exam03-result";
    }
}
