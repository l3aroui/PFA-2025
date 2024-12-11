package ma.emsi.productservice.dtos;

import java.util.Date;


public record SaleDTO(int quantity , double amount , Date saleDate) {
}
