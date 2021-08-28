package com.example.demo.security;

import com.example.demo.model.Employe;
import com.example.demo.repository.EmployRepasitory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class SecurityService implements UserDetailsService {
    private final EmployRepasitory employRepasitory;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Employe> byEmail=employRepasitory.findByEmail(s);
        if (!byEmail.isPresent()){
            throw new UsernameNotFoundException("Employe with"+s+"username dose not exists");
        }
        return new CurrentEmploee(byEmail.get());
    }
}
