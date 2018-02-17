public class Fish extends Pet {

    private int currentDepth;
    Fish(int startingPosition){
        currentDepth=startingPosition;
    }
    public int dive(int howDeep) {
        currentDepth=currentDepth + howDeep;
        if (currentDepth > 100){
            System.out.println("I'm too small and can't swim that deep!");
            currentDepth=currentDepth-howDeep;
        }
        else {
            System.out.println("Diving into the depth " + howDeep + " foot");
            System.out.println("I'm on the depth " + currentDepth + " foot below sea level");
        }
        return currentDepth;
    }
    public String say(String something) {
        System.out.println("Fish doesn't talk!");
        return something;
    }
}
