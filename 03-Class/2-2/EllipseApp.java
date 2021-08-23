import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class EllipseApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Ellipse {
    Ellipse2D el;
	Color borderColor, fillColor;

    Ellipse(int x, int y, int w, int h, Color border, Color fill) {
		this.borderColor = border;
		this.fillColor = fill;

		this.el = new Ellipse2D.Float(x, y, w, h);

    }

	void paint(Graphics2D g2d) {
		
		g2d.setColor(this.fillColor);
		g2d.fill(this.el);

        g2d.setPaint(this.borderColor);
		g2d.draw(this.el);
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
        this.setTitle("Java2D - Ellipse");
        this.setSize(1000, 1000);
        this.setVisible(true);
		this.getContentPane().setBackground(Color.white);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

		Ellipse el1 = new Ellipse(200, 100, 100, 200, Color.red, Color.green);
		Ellipse el2 = new Ellipse(700, 100, 150, 150, Color.green, Color.blue);
		Ellipse el3 = new Ellipse(500, 500, 300, 100, Color.blue, Color.red);

		el1.paint(g2d);
		el2.paint(g2d);
		el3.paint(g2d);
    }
}
