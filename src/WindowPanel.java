import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowPanel extends JPanel {
    int gen=1;
    public WindowPanel(int w, int h) {
        setSize(w, h);
    }






    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;

        Population population=new Population();
        population.createPopulation();
        Timer timer = new Timer(1000 / 600, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //called 60 times per second
                population.display();
                //
                population.Update();
                gen++;
                repaint();
            }

        });
        timer.start();
        population.display();
        g2.drawString((Integer.toString(gen)), 100, 100);
        g2.drawRect(5, 5, 5, 5);
        //putting timer (move method) in here accelerates it. Why? Not sure
    }


}
