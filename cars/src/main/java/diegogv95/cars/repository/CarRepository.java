package diegogv95.cars.repository;

import diegogv95.cars.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    @Query("select c from Car c where c.brand = ?1 and c.gas = ?2 and c.price <= ?3")
    List<Car> findByQuery(String brand, String gas, double maxPrice);
}
