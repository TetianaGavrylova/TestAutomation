public class Pet {
    int age;
    float weight;
    float height;
    String color;

    final public void sleep() {
        System.out.println("Good night, see you tomorrow!");
    }

    public void eat() {
        System.out.println("I'm starving, let't take a bite!");
    }

    public String say(String aWord) {
        return "OK! " +aWord;
    }
}
