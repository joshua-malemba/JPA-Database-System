package bijrep.repo;

import org.springframework.data.repository.CrudRepository;
import bijrep.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
