package com.anjani.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="purchaseparty")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PurchaseParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="contact")
    private String contact;

    @Column(name="email")
    private String email;

    @Column(name="gstno")
    String gstno;

    @Column(name="pan")
    String pan;
    
}
