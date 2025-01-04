package ma.emsi.productservice.Service.serviceImpl;

import ma.emsi.productservice.Service.SaleService;
import ma.emsi.productservice.dtos.SaleDTO;
import ma.emsi.productservice.Repository.SaleRepository;

import ma.emsi.productservice.module.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SaleServiceImp implements SaleService {

    private final SaleRepository saleRepository;
    @Autowired
    public SaleServiceImp(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale saveSale(SaleDTO saleDTO) {
        Sale sale= Sale.builder()
                .amount(saleDTO.getAmount())
                .saleDate(saleDTO.getSaleDate())
                .quantity(saleDTO.getQuantity())
                .saleDate(saleDTO.getSaleDate())
                .build();
        return saleRepository.save(sale);
    }

        @Override
        public Sale getSaleById(int id) {
            return saleRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Sale not found with id " + id));
        }

        @Override
        public List<Sale> getAllSales() {
            return saleRepository.findAll();
        }

}
