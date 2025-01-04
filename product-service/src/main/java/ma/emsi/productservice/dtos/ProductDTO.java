package ma.emsi.productservice.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class ProductDTO {
    private String name;
    private double price;
    private int quantity;
    private String description;
    private Long id;
}
