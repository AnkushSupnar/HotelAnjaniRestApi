package com.anjani.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "bill")
    @ToString.Exclude
    @JsonBackReference
    private Bill bill;

    @Column(name = "itemname")
    private String itemname;

    @Column(name = "quantity")
    private Float quantity;

    @Column(name = "rate")
    private Float rate;


    @Column(name = "amount")
    private Float amount;
}