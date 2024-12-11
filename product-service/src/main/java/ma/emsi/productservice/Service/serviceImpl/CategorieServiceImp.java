package ma.emsi.productservice.Service.serviceImpl;

import ma.emsi.productservice.Service.CategorieService;
import ma.emsi.productservice.dtos.CategorieDTO;
import ma.emsi.productservice.Repository.CategorieRepo;
import ma.emsi.productservice.module.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImp implements CategorieService {

    private final CategorieRepo categorieRepository ;
    @Autowired
    public CategorieServiceImp(CategorieRepo categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Categorie SaveCategorie(CategorieDTO categorieDTO){
        Categorie categorie=Categorie.builder()
                .name(categorieDTO.name())
                .build();
        return categorieRepository.save(categorie);
    }

    @Override

    public Categorie getCategorie(int id){
        return categorieRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found with id : " + id));

    }
    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }
    @Override
    public Categorie updateCategorie(int id, Categorie updatedCategorie) {
        Categorie existingCategorie = getCategorie(id);
        existingCategorie.setName(updatedCategorie.getName());
        return categorieRepository.save(existingCategorie);
    }

    @Override
    public void deleteCategorie(int id) {
        if (!categorieRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }
            categorieRepository.deleteById(id);
        }
    }
