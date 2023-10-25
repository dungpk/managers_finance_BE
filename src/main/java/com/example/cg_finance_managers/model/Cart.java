package com.example.cg_finance_managers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long cartId;
    private int cartNumber;
    private String accountType;
    private double surplus;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;



}
