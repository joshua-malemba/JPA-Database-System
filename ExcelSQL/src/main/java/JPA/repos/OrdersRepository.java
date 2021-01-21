package JPA.repos;

import org.springframework.data.repository.CrudRepository;

import JPA.model.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer>{

}
