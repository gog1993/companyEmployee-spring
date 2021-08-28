package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.repository.CompaniesRepository;
import com.example.demo.repository.EmployRepasitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class CompanyController {
    @Autowired
    private CompaniesRepository companiesRepository;
    @Autowired

    private EmployRepasitory employRepasitory;

    @GetMapping("/company")

    public String companies(ModelMap modelMap) {
        List<Company> all = companiesRepository.findAll();
        modelMap.addAttribute("companies", all);
        return "company";
    }

    @GetMapping("/addCompany")
    public String addCompany() {
        return "addCompany";
    }


    @PostMapping("/addCompany")
    public String addCompanyPost(@ModelAttribute Company companies) {
        companiesRepository.save(companies);
        return "redirect:/addCompany";
    }

    @GetMapping("/delete/{id}")
    @Transactional

    public String deleteCompany(@PathVariable("id") int id) {


        employRepasitory.deleteByCompany_Id(id);
        companiesRepository.deleteById(id);

        return "redirect:/company";
    }
}
