import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowPanel extends JPanel {
    public WindowPanel(int w, int h) {
        setSize(w, h);
    }






    public void paintComponent(Graphics g){
        Population population=new Population();
        population.createPopulation();
        population.display();
        population.Update();
        population.display();
        Graphics2D g2 = (Graphics2D)g;
        g2.drawRect(5, 5, 5, 5);
        //putting timer (move method) in here accelerates it. Why? Not sure
    }


}
