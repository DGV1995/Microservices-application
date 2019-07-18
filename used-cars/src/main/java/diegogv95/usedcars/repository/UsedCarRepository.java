package diegogv95.usedcars.repository;

import diegogv95.usedcars.entity.UsedCar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsedCarRepository extends CrudRepository <UsedCar, Long> {
    @Query("select c from UsedCar c where c.brand = ?1 and c.km <= ?2")
    List<UsedCar> findByBrandAndKm(String brand, Double km);
}
