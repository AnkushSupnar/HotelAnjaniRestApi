package com.anjani.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kirana")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Kirana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "party")
    private PurchaseParty party;

    @Column(name = "nettotal")
    private Float nettotal;

    @Column(name = "transaport")
    private Float transaport;

    @Column(name = "other")
    private Float other;

    @Column(name = "discount")
    private Float discount;

    @Column(name = "grandtotal")
    private Float grandtotal;

    @Column(name = "paid")
    private Float paid;


    @OneToMany(mappedBy = "kirana", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KiranaTransaction> kiranaTransactions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "bank")
    private Bank bank;

}