import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class MainFrame extends JFrame{

    public MainFrame() {
        setTitle("Random Bar Chart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        MainPanel grid = new MainPanel();
        add(grid);
        setVisible(true);

    }

    public class MainPanel extends JPanel {
        public MainPanel() {
            JButton btnRedraw = new JButton("Redraw");
            add(btnRedraw);
            btnRedraw.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            });
        }

        protected void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D) g;
            double x = 0;
            double y = 0;
            double size = 60;

            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    g2.draw(new Line2D.Double(x, y, x + size, y + size));
                    x += size;
                }
                y += size;
            }
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }
}
