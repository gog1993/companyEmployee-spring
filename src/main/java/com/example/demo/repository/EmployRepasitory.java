package com.example.demo.repository;

import com.example.demo.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployRepasitory extends JpaRepository<Employe, Integer> {
    Optional<Employe> deleteByCompany_Id(int id);

    Optional<Employe> findByName(String s);

    Optional<Employe> findByEmail(String s);
}
