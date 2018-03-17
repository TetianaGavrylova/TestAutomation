import javax.swing.JFrame;

public class RobotManager
{
    public static void main(String[] args) {

        Robot robot = new Robot(200, 50);

        robot.setCourse(67.5);
        robot.forward(115);

        robot.setCourse(0);
        robot.forward(112);

        robot.setCourse(120);
        robot.forward(140);

        robot.setCourse(67.5);
        robot.forward(112);

        robot.setCourse(202.5);
        robot.forward(140);

        robot.setCourse(157.5);
        robot.forward(140);

        robot.setCourse(292.5);
        robot.forward(112);

        robot.setCourse(240);
        robot.forward(140);

        robot.setCourse(0);
        robot.forward(112);

        robot.setCourse(292.5);
        robot.forward(115);

        // Создаем форму для отрисовки пути нашего робота
        RobotFrame rf = new RobotFrame(robot);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rf.setVisible(true);
    }
}