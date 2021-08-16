import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(1000, 850);
        this.setVisible(true);
		this.getContentPane().setBackground( Color.gray );
    }

    public void paint (Graphics g) {
        // super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.red);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
        g2d.draw(new Ellipse2D.Float(w / 4, h / 4, w / 2, h /2));
		g2d.setFont(new Font("Monospaced", Font.PLAIN, 64));
        g2d.drawString("LP2", w / 4, h / 5);
    }
}
