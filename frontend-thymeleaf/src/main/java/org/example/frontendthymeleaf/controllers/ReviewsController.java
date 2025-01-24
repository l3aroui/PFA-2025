package org.example.frontendthymeleaf.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reviews")
public class ReviewsController {
    @GetMapping
    public String reviewsPage(Model model){
        return "reviews";
    }
}
