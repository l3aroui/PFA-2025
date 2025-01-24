package org.example.frontendthymeleaf.controllers;

import org.example.frontendthymeleaf.model.Choice;
import org.example.frontendthymeleaf.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class ChoiceController {

    private final RestTemplate restTemplate;


    @Autowired
    public ChoiceController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/addChoiceForm")
    public String addChoiceForm(Model model,@RequestParam("id") Long questionId){
        String url="http://clientReviews-service/api/v1/reviews/admin/question/"+questionId;
        Question question=restTemplate.getForObject(url,Question.class);
        model.addAttribute("question",question);
        return "addChoiceForm";
    }

    @PostMapping("/addChoice")
    public String addChoice(@RequestParam Long questionId, @RequestParam String text){
        String url = "http://clientReviews-service/api/v1/reviews/choices/one/"+questionId;
        Choice choice = new Choice(null,text); // Assurez-vous que la classe `Choice` contient ces champs.
        restTemplate.postForObject(url, choice, Choice.class);
        return "redirect:/questions";
    }

}
