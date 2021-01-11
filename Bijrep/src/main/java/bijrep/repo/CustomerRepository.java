package bijrep.repo;

import bijrep.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <Customer, Integer>{

}
