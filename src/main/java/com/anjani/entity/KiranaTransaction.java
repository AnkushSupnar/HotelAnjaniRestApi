package com.anjani.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "kiranatransaction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class KiranaTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kirana")
    @ToString.Exclude
    private Kirana kirana;

    @Column(name = "itemname")
    private String itemname;

    @Column(name = "unit")
    private String unit;

    @Column(name = "quantity")
    private Float quantity;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "amount")
    private Float amount;

}