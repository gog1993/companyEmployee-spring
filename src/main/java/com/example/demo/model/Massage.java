package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="massage")

public class Massage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String massage;
    @ManyToOne
    @JoinColumn(name="from_id")
    private Employe fromEmployee;
    @ManyToOne
    @JoinColumn(name="to_id")
    private Employe toEmployee;


}
