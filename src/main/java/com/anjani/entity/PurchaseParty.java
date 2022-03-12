package com.anjani.entity;

import javax.annotation.processing.Generated;
import javax.persistence.*;

import org.hibernate.annotations.CollectionId;

import lombok.*;
import net.bytebuddy.utility.dispatcher.JavaDispatcher.IsConstructor;

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
