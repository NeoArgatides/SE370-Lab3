import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class ChartFrame extends JFrame{
    private JButton btnRedraw;
    private JPanel chartPanel;

    public ChartFrame() {
        setContentPane(chartPanel);
        setTitle("Random Bar Chart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

        btnRedraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //ChartPanel grid = new ChartPanel();
    }

    public class ChartPanel extends JPanel {
        @Override
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
        ChartFrame frame = new ChartFrame();
    }
}
