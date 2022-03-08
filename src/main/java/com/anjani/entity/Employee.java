package com.anjani.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;


    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;

    @Column(name = "designation")
    private String designation;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "salarytype")
    private String salarytype;

    @Column(name = "status")
    private String status;

}