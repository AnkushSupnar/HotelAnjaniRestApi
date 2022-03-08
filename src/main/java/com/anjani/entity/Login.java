package com.anjani.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="login")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="username")
    private String username;

    @Column(name="password")
	private String password;
    
    @OneToOne
    @JoinColumn(name="employeeid")
	private Employee employee;
}
