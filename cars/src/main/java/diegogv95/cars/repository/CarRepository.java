package diegogv95.cars.repository;

import diegogv95.cars.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    @Query("select c from Car c where c.brand = ?1 and c.gas = ?2")
    List<Car> findByBrandAndGas(String brand, String gas);
}
