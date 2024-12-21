package org.example.frontendthymeleaf.controller;


import org.example.frontendthymeleaf.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller

public class ClientResponseController {


    private final RestTemplate restTemplate;
    @Autowired
    public ClientResponseController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String clientFormulaire(Model model){

        String url = "http://clientReviews-service/api/v1/reviews/admin/question";
        Question[] response = restTemplate.getForObject(url, Question[].class);
        model.addAttribute("questions",response);
        return "clientForm";
    }


//    @GetMapping("/")
//    public String
}
