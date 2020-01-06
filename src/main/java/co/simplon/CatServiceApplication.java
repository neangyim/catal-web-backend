package co.simplon;

import co.simplon.dao.ProduitRepository;
import co.simplon.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatServiceApplication implements CommandLineRunner {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CatServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
		produitRepository.save(new Produit(null,"Ordinateur Pro Lx 45",1790,3));
		produitRepository.save(new Produit(null,"Imprimante HP",790,3));
		produitRepository.save(new Produit(null,"Smart Phone Sunsung S10",990,3));
		produitRepository.findAll().forEach(p -> {
			System.out.println(p.toString());
		});
	}
}
