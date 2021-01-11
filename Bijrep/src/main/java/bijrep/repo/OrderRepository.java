package bijrep.repo;

import org.springframework.data.repository.CrudRepository;
import bijrep.model.Orders;

public interface OrderRepository extends CrudRepository<Orders, Integer>{

}
