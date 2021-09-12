package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.model.Sale;

import java.io.Serializable;
import java.time.LocalDate;

public class SaleDto implements Serializable {

    private Long id;

    private Long visited;

    private Long deals;

    private Double amount;

    private LocalDate date;

    private SellerDto seller;

    public SaleDto() {
    }

    public SaleDto(Long id, Long visited, Long deals, Double amount, LocalDate date, SellerDto sellerDto) {
        this.id = id;
        this.visited = visited;
        this.deals = deals;
        this.amount = amount;
        this.date = date;
        this.seller = sellerDto;
    }

    public SaleDto(Sale sale) {
        this.id = sale.getId();
        this.visited = sale.getVisited();
        this.deals = sale.getDeals();
        this.amount = sale.getAmount();
        this.date = sale.getDate();
        this.seller = new SellerDto(sale.getSeller());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisited() {
        return visited;
    }

    public void setVisited(Long visited) {
        this.visited = visited;
    }

    public Long getDeals() {
        return deals;
    }

    public void setDeals(Long deals) {
        this.deals = deals;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public SellerDto getSeller() {
        return seller;
    }

    public void setSeller(SellerDto seller) {
        this.seller = seller;
    }
}
