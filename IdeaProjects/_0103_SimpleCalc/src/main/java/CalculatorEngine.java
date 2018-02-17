import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class CalculatorEngine implements ActionListener {
    public void actionPerformed(ActionEvent evt){
        JTextField myDisplayField=null;
        JButton clickedButton=null;
        Object eventSource = evt.getSource();
        if (eventSource instanceof JButton){
            clickedButton = (JButton) eventSource;
        }else if (eventSource instanceof JTextField) {
            myDisplayField = (JTextField) eventSource;
        }
    }
}