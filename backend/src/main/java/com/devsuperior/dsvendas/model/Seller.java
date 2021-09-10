package com.devsuperior.dsvendas.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "seller")
    private List<Sale> saleList;

    public Seller() {
    }

    public Seller(Long id, String name, List<Sale> saleList) {
        this.id = id;
        this.name = name;
        this.saleList = saleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }
}
