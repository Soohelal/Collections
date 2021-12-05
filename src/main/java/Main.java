public class Main {
    public static void main(String[] args) {
        CarCollection cars = new CarArrayList();

        for (int i = 0; i < 100; i++) {
            cars.add(new Car("brand" + i, i));
        }

        for (Car car: cars
             ) {
            System.out.println(car);
        }
    }
}
