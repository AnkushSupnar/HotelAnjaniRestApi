package com.anjani.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "temptransaction")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class TempTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item item;

    @Column(name = "quantity")
    private Float quantity;


    @Column(name = "amount")
    private Float amount;

    @ManyToOne
    @JoinColumn(name = "tablemasterid")
    private TableMaster tableMaster;

    @Column(name = "printqty")
    private Float printqty;

    @Column(name = "rate")
    private Float rate;

    @ManyToOne
    @JoinColumn(name = "employeeid")
    private Employee employee;

}