package diegogv95.usedcars.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UsedCarTest {

    private UsedCar usedCar;

    @BeforeAll
    void setUp() {
        usedCar = new UsedCar(1L, "Mercedes", "Class A 200", "Gasoline", 10000, 163, 20000);
    }

    @Test
    void testGetId() {
        assertThat(1L).isEqualTo(usedCar.getId());
    }

    @Test
    void testGetBrand() {
        assertThat("mercedes").isEqualToIgnoringCase(usedCar.getBrand());
    }

    @Test
    void testGetModel() {
        assertEquals("Class A 200", usedCar.getModel());
    }

    @Test
    void testGetGas() {
        assertThat("Gasoline").isEqualToIgnoringCase(usedCar.getGas());
    }

    @Test
    void testGetKm() {
        assertTrue(10000 == usedCar.getKm());
    }

    @Test
    void testGetPower() {
        assertTrue(163 == usedCar.getPower());
    }

    @Test
    void testGetPrice() {
        assertEquals(20000, usedCar.getPrice());
    }
}