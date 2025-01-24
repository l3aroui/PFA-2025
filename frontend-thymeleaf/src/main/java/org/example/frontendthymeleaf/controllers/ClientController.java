package org.example.frontendthymeleaf.controllers;

import org.bouncycastle.math.raw.Mod;
import org.example.frontendthymeleaf.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class ClientController {


    private final RestTemplate restTemplate;
    @Autowired
    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @GetMapping("/clients")
    public String getAllClients(Model model){
        String url = "http://serviceClient-com/api/v2/client/commercials/1";
        Client[] clients=restTemplate.getForObject(url,Client[].class);
        model.addAttribute("clients",clients);
        return "showClients";
    }
    @GetMapping("/addClientForm")
    public String addClientForm(){
        return "addClientForm";
    }
    @PostMapping("/addClient")
    public String addClient(Model model, @ModelAttribute Client client){
        String url="http://serviceClient-com/api/v2/client/1";
        restTemplate.postForObject(url,client,Client.class);
        return "redirect:/clients";
    }
}
