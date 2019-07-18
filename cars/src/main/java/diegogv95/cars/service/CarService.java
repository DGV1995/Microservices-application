package diegogv95.cars.service;

import diegogv95.cars.entity.Car;

import java.util.List;

public interface CarService {
    Car findById(Long id);
    List<Car> findAll();
    Car save(Car car);
    void deleteById(Long id);
    List<Car> findByBrandAndGas(String brand, String gas);
}
