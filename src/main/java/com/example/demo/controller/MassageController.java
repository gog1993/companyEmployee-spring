package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.model.Employe;
import com.example.demo.model.Massage;
import com.example.demo.repository.EmployRepasitory;
import com.example.demo.repository.MassageRepository;
import com.example.demo.security.CurrentEmploee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MassageController {
    @Autowired
    private EmployRepasitory employRepasitory;
    @Autowired
    private MassageRepository massageRepository;


    @GetMapping("/sendMassage")
    public  String getAllEmployee(ModelMap modelMap){
        List <Employe> all=employRepasitory.findAll();
        modelMap.addAttribute("employees", all);
        return "sendMassage";}

        @GetMapping("/showMassage")
    public  String getAllMassages(ModelMap modelMap, @AuthenticationPrincipal CurrentEmploee currentEmploee){
        List <Massage> all=massageRepository.findAllByToEmployee_Id(currentEmploee.getEmploye().getId());
        modelMap.addAttribute("massages", all);
        return "showMassage";


    }
    @PostMapping("/sendMassage")
    public String sendMassage(@ModelAttribute Massage massage, @AuthenticationPrincipal CurrentEmploee currentEmploee){
        massage.setFromEmployee(currentEmploee.getEmploye());
        massageRepository.save(massage);
        return "redirect:/employees";
    }

}
