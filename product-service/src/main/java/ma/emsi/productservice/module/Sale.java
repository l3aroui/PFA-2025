package ma.emsi.productservice.module;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter @Builder @Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private int quantity;
    private double amount;
    private Date saleDate ;

    @ManyToMany
    private List<Product> product ;
}
