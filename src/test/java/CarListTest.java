import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {

    private CarList carList;

    @Before
    public void setUp() throws Exception {
        carList = new CarLinkedList() {
        };

        for (int i = 0; i < 100; i++) {
            carList.add(new Car("brand" + i, i));
        }
    }

    @Test
    public void get() {
        Car car = new Car("brand0", 0);
        assertEquals(car.getBrand(),  "brand0");
    }

    @Test
    public void getSize() {
    }

    @Test
    public void add() {
        assertEquals(100, carList.getSize());
    }

    @Test
    public void removeByIndex() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.getSize());
    }

    @Test
    public void removeByCar() {
        Car car = new Car("mers", 15);
        carList.add(car);
        assertEquals(101, carList.getSize());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.getSize());
    }

    @Test
    public void clear() {
        carList.clear();
        assertEquals(0, carList.getSize());
    }

    @Test
    public void removedNotExistingElement() {
        Car car = new Car("mers", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.getSize());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void outOfIndex() {
      carList.get(103);
    }

    @Test
    public void addByIndex() {
        Car car = new Car("BMV", 22);
        carList.add(car, 50);
        assertEquals("BMV", car.getBrand());
        assertEquals(101, carList.getSize());
    }
}