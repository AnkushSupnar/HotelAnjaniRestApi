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

    @Column(name="itemname")
    String itemname;


    @Column(name = "quantity")
    private Float quantity;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "amount")
    private Float amount;

    @ManyToOne
    @JoinColumn(name = "tablemasterid")
    private TableMaster tableMaster;

    @ManyToOne
    @JoinColumn(name = "waitorid")
    private Employee employee;

    @Column(name = "printqty")
    private Float printqty;



//    @ManyToOne
//    @JoinColumn(name = "employeeid")
//    private Employee employee;

}