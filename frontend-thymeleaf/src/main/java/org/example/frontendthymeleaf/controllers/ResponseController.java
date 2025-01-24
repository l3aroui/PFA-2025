package org.example.frontendthymeleaf.controllers;

import org.example.frontendthymeleaf.model.ClientResponse;
import org.example.frontendthymeleaf.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ResponseController {

    private final RestTemplate restTemplate;

    @Autowired
    public ResponseController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/responseForm")
    public String responseForm(Model model,Long saleId){
        String url="http://clientReviews-service/api/v1/reviews/admin/question";
        Question[] questions=restTemplate.getForObject(url, Question[].class);
        model.addAttribute("questions",questions);
        return "responseForm";
    }

    @PostMapping("/saveResponse")
    public String saveResponse(
            //@RequestParam("saleId") Long saleId,
            @RequestBody List<ClientResponse> clientResponses) {
        String url = "http://clientReviews-service/api/v1/reviews/admin/question/saveResponse/" + 1;
        // Envoyer les réponses au microservice
        restTemplate.postForObject(url, clientResponses, ClientResponse[].class);
        return "redirect:/dashboard";
    }

}
