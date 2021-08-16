import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RectApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Rect {
    int x, y, w, h;
	Color borderColor, fillColor;

    Rect(int x, int y, int w, int h, Color border, Color fill) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.borderColor = border;
		this.fillColor = fill;
    }

    void print() {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

	int area() {
		return this.w * this.h;
	}
		
	void drag(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	void paint(Graphics2D g2d) {
		g2d.setColor(this.fillColor);
		g2d.fillRect(this.x, this.y, this.w, this.h);

        g2d.setPaint(this.borderColor);
		g2d.drawRect(this.x, this.y, this.w, this.h);
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
        this.setTitle("Java2D - Rect");
        this.setSize(1000, 1000);
        this.setVisible(true);
		this.getContentPane().setBackground(Color.white);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

		Rect rect1 = new Rect(200, 100, 100, 200, Color.red, Color.green);
		Rect rect2 = new Rect(700, 100, 150, 150, Color.green, Color.blue);
		Rect rect3 = new Rect(500, 500, 300, 100, Color.blue, Color.red);

		rect1.paint(g2d);
		rect2.paint(g2d);
		rect3.paint(g2d);
    }
}
