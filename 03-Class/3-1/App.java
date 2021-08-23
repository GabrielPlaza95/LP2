import figures.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;

public class App {
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

        this.setTitle("Java2D");
        this.setSize(1000, 1000);
        this.setVisible(true);
		this.getContentPane().setBackground(Color.white);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

		Rectangle rectangle = new Rectangle(200, 100, 100, 200, Color.red, Color.green);
		Ellipse ellipse = new Ellipse(700, 100, 150, 150, Color.green, Color.blue);
		Triangle triangle = new Triangle(500, 500, 300, 100, Color.blue, Color.red);

		rectangle.paint(g2d);
		ellipse.paint(g2d);
		triangle.paint(g2d);
    }
}
