package com.example.ex_beginner.controller;

import com.example.ex_beginner.domain.User;
import com.example.ex_beginner.form.UserForm;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
    @GetMapping()
    public String index(Model model, UserForm userForm) {
        return "exam04";
    }

    @PostMapping("/show-user")
    public String showUser(
            @Validated UserForm userForm
            , BindingResult result
            , Model model) {

        if (result.hasErrors()) {
            return index(model, userForm);
        }

        User user = new User();
//        user.setName(userForm.getName());
//        user.setAge(userForm.getIntVal(userForm.getAge()));
//        user.setComment(userForm.getComment());

        BeanUtils.copyProperties(userForm, user);
        user.setAge(userForm.getIntVal(userForm.getAge()));

        model.addAttribute("user", user);

        return "exam04-result";
    }
}
