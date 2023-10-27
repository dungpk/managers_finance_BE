package com.example.cg_finance_managers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "spending_range")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Spending {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long spendingId;
    private String spendingName;
    private double totalSpending;
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
