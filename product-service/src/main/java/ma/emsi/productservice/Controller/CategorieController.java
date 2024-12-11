package ma.emsi.productservice.Controller;


import ma.emsi.productservice.Service.CategorieService;
import ma.emsi.productservice.dtos.CategorieDTO;
import ma.emsi.productservice.module.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RequestMapping("/api/v1/product/Categorie")
@RestController
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @PostMapping("/saveCategory")
    public ResponseEntity<Categorie> createCategorie(@RequestBody CategorieDTO categorie) {
        return ResponseEntity.ok(categorieService.SaveCategorie(categorie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable int id) {
        return ResponseEntity.ok(categorieService.getCategorie(id));
    }

    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategorie() {
        return ResponseEntity.ok(categorieService.getAllCategories());
    }
}