package algorhytms;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mihails_nikitins on 02.08.2016.
 */
public class Fractal {
    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
class MyPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int X_SIZE = 1000;
    private static final int Y_SIZE = 600;
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public Dimension getPreferredSize() {
        return new Dimension(X_SIZE, Y_SIZE);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);

        drawFractal(g, 5, 20, 280, 280, 280);
        drawFractal(g, 7, 280, 280, 150, 20);
        drawFractal(g, 3, 150, 20, 20, 280);
    }

    private void drawFractal (Graphics g, int depth, int x1, int y1, int x5, int y5){
        int deltaX, deltaY, x2, y2, x3, y3, x4, y4;

        if (depth == 0){
            g.drawLine(x1, y1, x5, y5);
        }else{

            deltaX = x5 - x1;
            deltaY = y5 - y1;

            x2 = x1 + deltaX / 3;
            y2 = y1 + deltaY / 3;

            x3 = (int) (0.5 * (x1+x5) + Math.sqrt(3) * (y1-y5)/6);
            y3 = (int) (0.5 * (y1+y5) + Math.sqrt(3) * (x5-x1)/6);

            x4 = x1 + 2 * deltaX / 3;
            y4 = y1 + 2 * deltaY / 3;

            drawFractal(g, depth - 1, x1, y1, x2, y2);
            drawFractal(g, depth - 1, x2, y2, x3, y3);
            drawFractal(g, depth - 1, x3, y3, x4, y4);
            drawFractal(g, depth - 1, x4, y4, x5, y5);
        }
    }


}
