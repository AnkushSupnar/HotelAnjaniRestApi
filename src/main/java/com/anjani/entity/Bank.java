package com.anjani.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "accountno")
    private String accountno;

    @Column(name = "ifsc")
    private String ifsc;

    @Column(name = "address")
    private String address;

    @Column(name = "balance", nullable = false)
    private Float balance;

}