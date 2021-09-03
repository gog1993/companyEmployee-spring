package com.example.demo.repository;

import com.example.demo.model.Massage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MassageRepository extends JpaRepository<Massage, Integer> {
    List<Massage> findAllByToEmployee_Id(int id);

}
