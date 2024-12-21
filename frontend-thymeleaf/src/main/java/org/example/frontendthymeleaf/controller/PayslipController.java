package org.example.frontendthymeleaf.controller;

import org.example.frontendthymeleaf.model.Payslip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/payslips")
public class PayslipController {

    @Autowired
    private RestTemplate restTemplate;

    // Afficher la liste des fiches de paie
    @GetMapping
    public String getPayslips(Model model) {
        Payslip[] payslips = restTemplate.getForObject("http://payslip-service/payslips", Payslip[].class);
        model.addAttribute("payslips", payslips);
        model.addAttribute("activePage", "payslips");
        return "payslips";
    }

    // Afficher le formulaire de génération d'une fiche de paie
    @GetMapping("/add")
    public String showAddPayslipForm(Model model) {
        model.addAttribute("payslip", new Payslip());
        return "add_payslip";
    }

    // Traiter la génération d'une fiche de paie
    @PostMapping
    public String addPayslip(@ModelAttribute Payslip payslip) {
        restTemplate.postForObject("http://payslip-service/payslips", payslip, Payslip.class);
        return "redirect:/payslips";
    }

    // Afficher le formulaire de modification d'une fiche de paie
    @GetMapping("/edit/{id}")
    public String showEditPayslipForm(@PathVariable Long id, Model model) {
        Payslip payslip = restTemplate.getForObject("http://payslip-service/payslips/" + id, Payslip.class);
        model.addAttribute("payslip", payslip);
        return "edit_payslip";
    }

    // Traiter la modification d'une fiche de paie
    @PostMapping("/update/{id}")
    public String updatePayslip(@PathVariable Long id, @ModelAttribute Payslip payslip) {
        restTemplate.put("http://payslip-service/payslips/" + id, payslip);
        return "redirect:/payslips";
    }

    // Supprimer une fiche de paie
    @GetMapping("/delete/{id}")
    public String deletePayslip(@PathVariable Long id) {
        restTemplate.delete("http://payslip-service/payslips/" + id);
        return "redirect:/payslips";
    }
}
