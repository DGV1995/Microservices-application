package diegogv95.usedcars.service;

import diegogv95.usedcars.entity.UsedCar;

import java.util.List;

public interface UsedCarService {
    List<UsedCar> findByQuery(String brand, double km, double price);
    UsedCar findById(Long id);
    UsedCar save(UsedCar car);
    void deleteById(Long id);
}