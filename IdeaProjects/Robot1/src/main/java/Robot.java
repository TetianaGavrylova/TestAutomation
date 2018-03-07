public class Robot {
    // Текущая координата X
    double x = 0;
    // Текущая координата Y
    double y = 0;
    // Текущий курс (в градусах)
    double course = 0;

    // Печать координат робота
    void printCoordinates() {
        System.out.println(x + "," + y);
    }

    // Передвижение на дистанцию distance
    // учтите, что угол надо передавать в радианах. Для того, что бы работать в градусах
    // мы преобразуем градусы в радианы путем деления на 180 и умножением на PI (Пи - 3,14159)
    void forward(int distance) {
        // Обращение к полю объекта X
        x = x + distance * Math.cos(course / 180 * Math.PI);
        // Обращение к полю объекта Y
        y = y + distance * Math.sin(course / 180 * Math.PI);
    }
}
