public interface CarCollection {

    boolean add (Car car);
    boolean remove (Car car);
    void clear();
    int getSize();
    boolean contains(Car car);
}
