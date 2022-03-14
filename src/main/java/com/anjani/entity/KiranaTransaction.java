package com.anjani.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "kiranatransaction")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class KiranaTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "kirana")
    @ToString.Exclude
    @JsonBackReference
    private Kirana kirana;

    @Column(name = "itemname")
    private String itemname;

    @Column(name = "unit")
    private String unit;

    @Column(name = "quantity")
    private Float quantity;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "amount")
    private Float amount;
/*
    public Long getId() {
        return id;
    }

    @JsonBackReference
    public Kirana getKirana() {
        return kirana;
    }

    public String getItemname() {
        return itemname;
    }

    public String getUnit() {
        return unit;
    }

    public Float getQuantity() {
        return quantity;
    }

    public Float getRate() {
        return rate;
    }

    public Float getAmount() {
        return amount;
    }
*/
}
