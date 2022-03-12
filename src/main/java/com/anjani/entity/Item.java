package com.anjani.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="itemname")
    String itemname;

    @ManyToOne
    @JoinColumn(name = "catid")
    Category catid;

    @Column(name="rate")
    Float rate;

    @Column(name="itemcode")
    Integer itemcode;
}