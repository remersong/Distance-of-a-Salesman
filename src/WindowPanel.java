import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowPanel extends JPanel {
    int gen = 1;
    Population population = new Population();


    public WindowPanel(int w, int h) {
        setSize(w, h);
        population.createPopulation();

    }


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (City c : population.getCities()) {
            g2.fillOval(c.getX() - 5, c.getY() - 5, 10, 10);
        }
        g2.setStroke(new BasicStroke(1));
        for (int i = 0; i < population.getPopulation().length/2; i++) {
            g2.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255), (int)(Math.random()*255) ));

            for (int c = 0; c < population.getPopulation()[i].size() - 1; c++) {
                g2.drawLine(population.getPopulation()[i].get(c).getX(), population.getPopulation()[i].get(c).getY(), population.getPopulation()[i].get(c+1).getX(),population.getPopulation()[i].get(c+1).getY());
            }
        }
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        for (int i = 0; i < population.getLowestValue().size() - 1; i++) {
            g2.drawLine(population.getLowestValue().get(i).getX(), population.getLowestValue().get(i).getY(), population.getLowestValue().get(i + 1).getX(), population.getLowestValue().get(i + 1).getY());
        }



        population.display();
        population.Update();
        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //called 60 times per second
                gen++;
                repaint();
            }

        });
        timer.start();

        g2.drawString("Gen: " + (Integer.toString(gen)), 100, 700);
        g2.drawString("Distance: " + (Integer.toString(population.getScore(population.getLowestValue()))), 100, 750);

        g2.drawRect(5, 5, 5, 5);
        //putting timer (move method) in here accelerates it. Why? Not sure
    }


}
