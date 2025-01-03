package ma.emsi.productservice.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public record SaleDTO(int quantity , double amount , Date saleDate) {
}
