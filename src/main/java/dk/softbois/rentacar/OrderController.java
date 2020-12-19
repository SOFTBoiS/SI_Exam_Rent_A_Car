package dk.softbois.rentacar;

import models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;
    private Object Order;

    @GetMapping("/")
    public List<Order> retrieveAllOrders() {
        return orderRepo.findAll();
    }

    @GetMapping("/{id}")
    public Order retrieveOrder(@PathVariable String id) {
        return orderRepo.findOneById(id);
    }

    @GetMapping("/username/{username}")
    public List<Order> findAllByUsername(@PathVariable String username) {
        return (List<Order>) orderRepo.findAllByUsername(username);
    }

    @GetMapping("/car-id/{carId}")
    public List<Order> findAllByCarId(@PathVariable int carId) {
        return (List<Order>) orderRepo.findAllByCarId(carId);
    }

    @PostMapping("/")
    public ResponseEntity makeOrder(@RequestBody Order order) {
        System.out.println("MakeOrder start");
        Order saved = orderRepo.save(order);
        System.out.println("order save response: " + saved.toString());
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable String id) {
        orderRepo.deleteById(id);
        return "Order deleted";
    }

}
