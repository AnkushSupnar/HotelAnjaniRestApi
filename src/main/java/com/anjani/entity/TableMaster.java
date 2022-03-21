package com.anjani.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "tablemaster")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class TableMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tablename")
    private String tablename;

    @ManyToOne
    @JoinColumn(name = "tablegroupid")
    private TableGroup tableGroup;

    @Column(name = "othercharges")
    private Float othercharges;

}