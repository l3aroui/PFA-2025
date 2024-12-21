package ma.emsi.productservice.module;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Builder @Getter @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id ;
    private String name ;
    @OneToMany
    private List<Product> product ;
}
