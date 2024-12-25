package ma.emsi.productservice.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public record ProductDTO(String name,double price,int quantity,String description,int id) {

}
