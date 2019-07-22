package diegogv95.usedcars.service;

import diegogv95.usedcars.entity.UsedCar;
import diegogv95.usedcars.repository.UsedCarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class UsedCarServiceImplTest {

    @Mock
    private UsedCarRepository repository;

    @InjectMocks
    private UsedCarServiceImpl service;

    @Test
    void findByQuery() {
        // When
        service.findByQuery("Mercedes", 20000, 15000);

        // Then
        then(repository).should().findByQuery(any(String.class), any(double.class), any(double.class));
    }

    @Test
    void findById() {
        // When
        UsedCar car = service.findById(1L);

        // Then
        then(repository).should().findById(any(Long.class));
    }

    @Test
    void save() {
        // When
        service.save(new UsedCar());
        service.save(new UsedCar());

        // Then
        then(repository).should(times(2)).save(any(UsedCar.class));
    }

    @Test
    void deleteById() {
        // When
        service.deleteById(1L);

        // Then
        then(repository).should().deleteById(any(Long.class));
    }
}