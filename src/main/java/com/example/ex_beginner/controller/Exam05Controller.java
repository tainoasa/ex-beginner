package com.example.ex_beginner.controller;

import com.example.ex_beginner.domain.Member;
import com.example.ex_beginner.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
    @GetMapping()
    public String index() {
        return "exam05";
    }

    @Autowired
    MemberRepository repository;

    @PostMapping("/show-result")
    public String showResult(String keyWord, Model model) {
        List<Member> memberList = repository.getName(keyWord);
        model.addAttribute("memberList", memberList);
        System.out.println(memberList);
        return "exam05-result";
    }
}
