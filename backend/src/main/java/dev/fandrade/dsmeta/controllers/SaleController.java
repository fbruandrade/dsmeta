package dev.fandrade.dsmeta.controllers;

import dev.fandrade.dsmeta.entities.Sale;
import dev.fandrade.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> findAll() {
        return saleService.findSales();
    }
}
