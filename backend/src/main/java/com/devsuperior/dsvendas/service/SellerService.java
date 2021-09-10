package com.devsuperior.dsvendas.service;

import com.devsuperior.dsvendas.dto.SellerDto;
import com.devsuperior.dsvendas.model.Seller;
import com.devsuperior.dsvendas.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<SellerDto> findAll() {
        List<Seller> sellerList = sellerRepository.findAll();
        return sellerList.stream()
                .map(SellerDto::new)
                .collect(Collectors.toList());
    }
}
