package diegogv95.cars.service;

import diegogv95.cars.entity.Car;
import diegogv95.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository repository;

    @Autowired
    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Car findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Car> findAll() {
        return (List<Car>) repository.findAll();
    }

    @Override
    public Car save(Car car) {
        return repository.save(car);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Car> findByBrandAndGas(String brand, String gas) {
        return repository.findByBrandAndGas(brand, gas);
    }

}
