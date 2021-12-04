import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarSetTest {

    private CarSet carSet;

    @Before
    public void setUp() throws Exception {
        carSet = new CarSetList();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("brand" + i, i));
        }
    }

    @Test
    public void add() {
        assertFalse(carSet.add(new Car("brand32", 32)));
        assertEquals(100, carSet.getSize());
    }

    @Test
    public void whenAdd3SimilarObjectsThenSizeIncreaseBy1() {
        assertEquals(100, carSet.getSize());
        assertTrue(carSet.add(new Car("BMW", 10)));
        assertFalse(carSet.add(new Car("BMW", 10)));
        assertFalse(carSet.add(new Car("BMW", 10)));
        assertEquals(101, carSet.getSize());
    }

    @Test
    public void add2similarObj() {
        Car car = new Car("Mers", 10);
        assertTrue(carSet.add(car));
        assertFalse(carSet.add(car));
        assertEquals(101, carSet.getSize());
    }

    @Test
    public void remove() {
        Car car = new Car("mers", 15);
        carSet.add(car);
        assertTrue(carSet.remove(car));
        assertEquals(100, carSet.getSize());
        assertFalse(carSet.remove(car));
    }

    @Test
    public void clear() {
        carSet.clear();
        assertEquals(0, carSet.getSize());
    }

    @Test
    public void size() {
        assertEquals(100, carSet.getSize());
    }
}