package com.anjani.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tablegroup")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TableGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "groupname")
    private String groupname;

}