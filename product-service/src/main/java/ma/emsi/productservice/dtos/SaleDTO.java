package ma.emsi.productservice.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @Builder
public class SaleDTO{
    private int quantity;
    private double amount;
    private Date saleDate;
}
