package com.example.demo.security;

import com.example.demo.model.Employe;
import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentEmploee extends org.springframework.security.core.userdetails.User{


    private Employe employe;

    public CurrentEmploee(Employe employe) {
        super(employe.getEmail(), employe.getPassword(), AuthorityUtils.createAuthorityList(employe.getEmployee_type().name()));
        this.employe = employe;
    }

    public Employe getEmploye() {
        return employe;
    }
}
