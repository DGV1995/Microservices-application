package diegogv95.usedcars.repository;

import diegogv95.usedcars.entity.UsedCar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsedCarRepository extends CrudRepository <UsedCar, Long> {
    @Query("select c from UsedCar c where c.brand = ?1 and c.km <= ?2 and c.price <= ?3")
    List<UsedCar> findByQuery(String brand, Double km, Double price);
}
