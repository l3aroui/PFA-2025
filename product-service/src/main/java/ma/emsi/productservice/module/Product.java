package ma.emsi.productservice.module;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Getter @Builder @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private double price;
    private int quantity;
    private String description;
    @OneToMany
    private List<Sale> sales;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
