package diegogv95.cars.service;

import diegogv95.cars.entity.Car;
import diegogv95.cars.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @Mock
    private CarRepository repository;

    @InjectMocks
    private CarServiceImpl service;

    private Car car;

    @Test
    void findById() {
        // When
        Car car = service.findById(1L);

        // Then
        then(repository).should().findById(any(Long.class));
    }

    @Test
    void findAll() {
        // When
        List<Car> list = service.findAll();

        // Then
        then(repository).should().findAll();
    }

    @Test
    void save() {
        // When
        service.save(new Car());
        service.save(new Car());

        // Then
        then(repository).should(times(2)).save(any(Car.class));
    }

    @Test
    void deleteById() {
        // When
        service.deleteById(1L);

        // Then
        then(repository).should().deleteById(any(Long.class));
    }

    @Test
    void findByQuery() {
        // When
        service.findByQuery("Volvo", "Gasoline", 30000);

        // Then
        then(repository).should().findByQuery(any(String.class), any(String.class), any(double.class));
    }
}