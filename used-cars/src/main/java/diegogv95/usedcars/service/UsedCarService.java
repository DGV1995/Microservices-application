package diegogv95.usedcars.service;

import diegogv95.usedcars.entity.UsedCar;

import java.util.List;

public interface UsedCarService {
    List<UsedCar> findByBrandAndKm(String brand, double km);
}
