import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Random;

public class MainFrame extends JFrame{

    public MainFrame() {
        setTitle("Random Bar Chart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 580);

        JPanel mainPanel = new JPanel() {
            Random rand = new Random();

            @Override
            protected void paintComponent(Graphics g)
            {
                Graphics2D g2 = (Graphics2D) g;
                double x = 10;
                double y = 10;
                double size = 500;

                for(int i = 0; i < 11; i++) { //grid columns
                    g2.draw(new Line2D.Double(x, y, x, y + size));
                    x += (size/10);
                }
                x = 10;
                for(int i = 0; i < 11; i++) { //grid rows
                    g2.draw(new Line2D.Double(x, y, x + size, y));
                    y += (size/10);
                }

                g2.setStroke(new BasicStroke(10));
                x = 10 + (size/10);
                y = size + 5;
                for(int i = 0; i < 12; i++) { //bars
                    g2.setColor(new Color(rand.nextInt(255)+1, rand.nextInt(255)+1, rand.nextInt(255)+1));
                    g2.draw(new Line2D.Double(x, y, x, 15 + rand.nextInt((int)size)));
                    x += (size/15);
                }

                g2.dispose();
            }
        };

        JButton btnRedraw = new JButton("Redraw");
        btnRedraw.addActionListener(new ActionListener() { //redraw bars button
            public void actionPerformed(ActionEvent e) {
                mainPanel.repaint();
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnRedraw);
        getContentPane().add(BorderLayout.CENTER, mainPanel);
        getContentPane().add(BorderLayout.SOUTH, btnPanel);

        setVisible(true);

    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }
}
