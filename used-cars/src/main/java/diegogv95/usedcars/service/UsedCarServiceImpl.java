package diegogv95.usedcars.service;

import diegogv95.usedcars.entity.UsedCar;
import diegogv95.usedcars.repository.UsedCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsedCarServiceImpl implements UsedCarService {

    private UsedCarRepository repository;

    @Autowired
    public UsedCarServiceImpl(UsedCarRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsedCar> findByQuery(String brand, double km, double price) {
        return repository.findByQuery(brand, km, price);
    }

    @Transactional(readOnly = true)
    public UsedCar findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public UsedCar save(UsedCar car) {
        return repository.save(car);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
