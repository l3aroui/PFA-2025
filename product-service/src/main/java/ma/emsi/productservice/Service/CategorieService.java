package ma.emsi.productservice.Service;



import ma.emsi.productservice.dtos.CategorieDTO;
import ma.emsi.productservice.module.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie SaveCategorie(CategorieDTO categorieDTO) ;
    Categorie getCategorie(int id);
    List<Categorie> getAllCategories();
    Categorie updateCategorie(int id, Categorie categorie);
    void deleteCategorie(int id);
}
