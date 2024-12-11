package ma.emsi.productservice.Controller;


import ma.emsi.productservice.dtos.SaleDTO;
import ma.emsi.productservice.Service.SaleService;
import ma.emsi.productservice.module.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/v1/product/sales")
@RestController
public class SaleController {

    private final SaleService saleService;
    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/saveSales")
    public ResponseEntity<Sale> createSale(@RequestBody SaleDTO sale) {
        return ResponseEntity.ok(saleService.saveSale(sale));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable int id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }
}
