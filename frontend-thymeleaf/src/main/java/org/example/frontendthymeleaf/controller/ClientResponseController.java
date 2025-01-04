package org.example.frontendthymeleaf.controller;


import org.example.frontendthymeleaf.model.ClientResponse;
import org.example.frontendthymeleaf.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/response")
public class ClientResponseController {
    private final RestTemplate restTemplate;
    @Autowired
    public ClientResponseController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping
    public String saveClientResponse(@RequestParam List<Map<String,String>> questionResponse,
                                     @RequestParam Long clientId,
                                     @RequestParam Long saleId){

        String url="http://clientReviews-service/api/v1/reviews/client/saveResponse";
        ClientResponse clientResponse= new ClientResponse(clientId,saleId,questionResponse,null);
        restTemplate.postForEntity(url, clientResponse,ClientResponse[].class);
        return "redirect:clientResponse";
    }

    @GetMapping("/clientForm/{id}")
    public String clientFormulaire(Model model,@PathVariable("id") Long saleId){
        String url = "http://clientReviews-service/api/v1/reviews/admin/question/response/"+saleId;
        Question[] response = restTemplate.getForObject(url, Question[].class);
        model.addAttribute("questions",response);
        return "clientForm";
    }
    
    @GetMapping("/clientResponse/{id}")
    public String clientResponse(Model model, @PathVariable("id") Long saleId){
        String url = "http://clientReviews-service/api/v1/reviews/client/response/"+saleId;
        Question[] response = restTemplate.getForObject(url, Question[].class);
        model.addAttribute("questions",response);
        return "clientForm";
    }
}
