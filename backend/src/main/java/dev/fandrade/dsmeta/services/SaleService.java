package dev.fandrade.dsmeta.services;

import dev.fandrade.dsmeta.entities.Sale;
import dev.fandrade.dsmeta.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
        if (minDate.isEmpty() || maxDate.isEmpty()) {
            return saleRepository.findAll(pageable);
        } else {
            LocalDate min = LocalDate.parse(minDate);
            LocalDate max = LocalDate.parse(maxDate);
            return saleRepository.findSales(min, max, pageable);
        }
    }
}
