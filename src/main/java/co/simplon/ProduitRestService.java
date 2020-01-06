package co.simplon;

import co.simplon.dao.ProduitRepository;
import co.simplon.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestService {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "/listProduits")
    public List<Produit> listPruduits() {
        return produitRepository.findAll();
    }

    @GetMapping(value = "/listProduits/{id}")
    public Produit listPruduits(@PathVariable(name = "id") Long id) {
        return produitRepository.findById(id).get();
    }

    @PutMapping(value = "/listProduits/{id}")
    public Produit update(@PathVariable(name = "id") Long id,@RequestBody Produit p) {
        p.setId(id);
        return produitRepository.save(p);
    }

    @PostMapping(value = "/listProduits")
    public Produit save(@RequestBody Produit p) {
        return produitRepository.save(p);
    }

    @DeleteMapping(value = "/listProduits/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        produitRepository.deleteById(id);
    }
}