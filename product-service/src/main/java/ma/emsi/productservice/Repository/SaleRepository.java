package ma.emsi.productservice.Repository;


import ma.emsi.productservice.module.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
