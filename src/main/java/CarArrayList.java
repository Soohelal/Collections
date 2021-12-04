import java.util.Arrays;
import java.util.stream.IntStream;

public class CarArrayList implements CarList {

    Car[] carArrayList = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return carArrayList[index];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(Car car) {
        increaseArray();
        carArrayList[size] = car;
        size++;
    }

    @Override
    public void add(Car car, int index) {
        increaseArray();
        IntStream.iterate(size, i -> i < index, i -> i - 1).forEach(i -> {
            carArrayList[i] = carArrayList[i - 1];
            carArrayList[index] = car;
        });
        size++;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        if (size - 1 - index >= 0)
            System.arraycopy(carArrayList, index + 1, carArrayList, index, size - 1 - index);
        size--;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (carArrayList[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Car[] carArrayList = new Car[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void increaseArray() {
        if (size >= carArrayList.length) {
            carArrayList = Arrays.copyOf(carArrayList, carArrayList.length * 2);
        }
    }
}
