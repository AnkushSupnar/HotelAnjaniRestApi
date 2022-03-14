package com.anjani.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern="yyyy-MM-dd")
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
    @JsonManagedReference
    private List<KiranaTransaction> kiranaTransactions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "bank")
    private Bank bank;
/*
    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public PurchaseParty getParty() {
        return party;
    }

    public Float getNettotal() {
        return nettotal;
    }

    public Float getTransaport() {
        return transaport;
    }

    public Float getOther() {
        return other;
    }

    public Float getDiscount() {
        return discount;
    }

    public Float getGrandtotal() {
        return grandtotal;
    }

    public Float getPaid() {
        return paid;
    }

    @JsonManagedReference
    public List<KiranaTransaction> getKiranaTransactions() {
        return kiranaTransactions;
    }

    public Bank getBank() {
        return bank;
    }*/
}