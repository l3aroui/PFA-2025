package ma.emsi.productservice.Service;


import ma.emsi.productservice.dtos.SaleDTO;
import ma.emsi.productservice.module.Sale;

import java.util.List;

public interface SaleService {
    Sale saveSale(SaleDTO saleDTO);

    Sale getSaleById(int id);

    List<Sale> getAllSales();
}