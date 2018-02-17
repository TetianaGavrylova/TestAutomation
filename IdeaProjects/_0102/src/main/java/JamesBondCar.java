public class JamesBondCar extends Car {

    public void disappear (){
        System.out.println("Let's disappear for everyone!");
    }

    public int drive (int howlong){
        System.out.println("Come on, why so slow?");
        return howlong*180;
    }
}
