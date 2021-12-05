import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarCollectionTest {

    private CarCollection carCollection;

    @Before
    public void setUp() throws Exception {
        carCollection = new CarSetList() {
        };

        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car("brand" + i, i));
        }
    }

    @Test
    public void forEach() {
        int index = 0;
        for (Car car : carCollection
        ) {
            index++;
        }
        assertEquals(100, index);
    }

}