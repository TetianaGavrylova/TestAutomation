import javax.swing.JFrame;

public class RobotManager
{
    public static void main(String[] args) {

        Robot robot = new Robot(100, 50);

        int k = 500;
        while (k!=0) {
            int j = 0;
            for (int i = j; i < 271; i += 90) {
                if (i == 0 && k == 500) {
                    int n = k - 10;
                    robot.setCourse(i);
                    robot.forward(n);
                } else {
                    if (i == 90 || i == 270) {
                        k -= 10;
                        robot.setCourse(i);
                        robot.forward(k);
                    } else {
                        robot.setCourse(i);
                        robot.forward(k);
                    }

                }
            }
        }


        // Создаем форму для отрисовки пути нашего робота
        RobotFrame rf = new RobotFrame(robot);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rf.setVisible(true);
    }
}