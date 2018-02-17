public class CarOwner {

    public static void main(String[] args) {
        int drivingDistance;
        Car myCar = new Car();
        myCar.start();
        drivingDistance = myCar.drive(2);
        System.out.println("We'll drive " + drivingDistance + " km");
        myCar.stop();
    }
}
