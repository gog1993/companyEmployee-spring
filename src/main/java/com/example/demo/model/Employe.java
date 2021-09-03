package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="employees")

public class Employe {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   private String surname;
   @ManyToOne
   private Company company;
   private String position;
   private  String email;
   private  int phoneNumber;
   private  double salary;
   private String password;
  @Enumerated(value = EnumType.STRING)
   private EmployeeType employee_type;


}
