public class JamesBondHimself {

    public static void main(String[] args) {
        int drivingDistance;
        JamesBondCar JBCar = new JamesBondCar();
        JBCar.start();
        JBCar.disappear();
        drivingDistance = JBCar.drive(2);
        System.out.println("We'll drive " + drivingDistance + " km");
        JBCar.stop();
    }
}
