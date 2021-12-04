public interface CarList {

    Car get(int index);
    int getSize();
    void add (Car car);
    void add (Car car, int index);
    boolean removeAt (int index);
    boolean remove (Car car);
    void clear();





}
