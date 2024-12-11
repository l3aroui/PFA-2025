package ma.emsi.productservice.Repository;


import ma.emsi.productservice.module.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<Categorie, Integer> {

}
