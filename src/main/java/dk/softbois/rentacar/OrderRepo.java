package dk.softbois.rentacar;

import models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepo extends MongoRepository<Order, String> {
    Iterable<Order> findAllByCarId(int carId);
    Iterable<Order> findAllByUsername(String username);
}
