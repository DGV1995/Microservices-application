package diegogv95.cars.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car(1L, "Volvo", "S60 T5", "Gasoline", 8.0f, 7.2f, 250, 45000);
    }

    @Test
    public void getId() {
        assertThat(1L).isEqualTo(car.getId());
    }
    @Test
    public void getBrand() {
        assertThat("Volvo").isEqualTo(car.getBrand());
    }

    @Test
    public void getModel() {
        assertThat("S60 T5").isEqualTo(car.getModel());
    }

    @Test
    public void getGas() {
        assertThat("Gasoline").isEqualTo(car.getGas());
    }

    @Test
    public void getConsumption() {
        assertEquals(8.0f, car.getConsumption());
    }

    @Test
    public void getAcceleration() {
        assertEquals(7.2f, car.getAcceleration());
    }

    @Test
    public void getPower() {
        assertThat(250).isEqualTo(car.getPower());
    }

    @Test
    public void getPrice() {
        assertEquals(45000, car.getPrice());
    }

}