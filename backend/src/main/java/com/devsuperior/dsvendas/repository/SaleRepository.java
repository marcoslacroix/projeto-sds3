package com.devsuperior.dsvendas.repository;

import com.devsuperior.dsvendas.dto.SaleSucessDto;
import com.devsuperior.dsvendas.dto.SaleSumDto;
import com.devsuperior.dsvendas.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("select new com.devsuperior.dsvendas.dto.SaleSumDto(obj.seller, sum(obj.amount)) " +
            "from Sale as obj group by obj.seller")
    List<SaleSumDto> amountGroupedBySeller();

    @Query("select new com.devsuperior.dsvendas.dto.SaleSucessDto(obj.seller, sum(obj.visited), sum(obj.deals)) " +
            "from Sale as obj group by obj.seller")
    List<SaleSucessDto> saleSucess();
}
