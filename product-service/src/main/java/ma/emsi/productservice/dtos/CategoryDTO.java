package ma.emsi.productservice.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public record CategoryDTO(String name) {

}
