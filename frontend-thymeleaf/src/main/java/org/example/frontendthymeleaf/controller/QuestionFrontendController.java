package org.example.frontendthymeleaf.controller;
import org.example.frontendthymeleaf.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class QuestionFrontendController {

    @Value("${api.gateway.url:http://localhost:8222}")
    private String apiGatewayUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public QuestionFrontendController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/questions")
    public String getAllQuestions(Model model) {
        String url = "http://clientReviews-service/api/v1/reviews/admin/question";
        Question[] response = restTemplate.getForObject(url, Question[].class);
        model.addAttribute("questions", response);
        return "questions"; // Render "questions.html"
    }

    @GetMapping("/question/form")
    public String formQuestion(){
        return "form_question";
    }

    @PostMapping("/questions/add")
    public String createQuestion(@RequestParam("text") String text,
                                 @RequestParam("type") String type,
                                 @RequestParam(value = "required", defaultValue = "false") boolean required ) {
        String url = "http://clientReviews-service/api/v1/reviews/admin/question/add";
        Question question = new Question(null,text,type,required,null);
        restTemplate.postForEntity(url,question, Question.class);
        return "redirect:/questions";
    }

    @GetMapping("/questions/delete")
    public String deleteQuestion(@RequestParam Long questionId) {
        String url = "http://clientReviews-service/api/v1/reviews/admin/question/delete/" + questionId;
        restTemplate.delete(url);
        return "redirect:/questions";
    }

}
