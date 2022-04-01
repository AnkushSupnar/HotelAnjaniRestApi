package com.anjani.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bill")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "netamount")
    private Float netamount;

    @Column(name = "discount")
    private Float discount;

    @Column(name = "grandtotal")
    private Float grandtotal;

    @Column(name = "paid")
    private Float paid;

    @ManyToOne
    @JoinColumn(name = "bank")
    private Bank bank;


    @ManyToOne
    @JoinColumn(name = "waitor")
    private Employee waitor;

    @ManyToOne
    @JoinColumn(name = "login")
    private Employee login;

    @ManyToOne
    @JoinColumn(name = "tableid")
    private TableMaster table;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    private String status;
}