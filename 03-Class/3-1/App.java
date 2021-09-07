import figures.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
    }
}

class Hello2DFrame extends JFrame {
	ArrayList<Rectangle> rectangleList;
	ArrayList<Ellipse> ellipseList;

    public Hello2DFrame () {
		Random rand = new Random();

        this.setTitle("Java2D");
        this.setSize(1000, 1000);
        this.setVisible(true);
		this.getContentPane().setBackground(Color.white);

		this.rectangleList = new ArrayList<Rectangle>();
		this.ellipseList = new ArrayList<Ellipse>();

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

		this.addKeyListener (
			new KeyAdapter() {
				public void keyPressed (KeyEvent evt) {
					if (evt.getKeyChar() == 'e') {
						int x = rand.nextInt(800);
						int y = rand.nextInt(800);
						int w = rand.nextInt(200);
						int h = rand.nextInt(200);

						ellipseList.add(new Ellipse(x, y, w, h, Color.pink, Color.pink));
						repaint();
					} 

					if (evt.getKeyChar() == 'r') {
						int x = rand.nextInt(800);
						int y = rand.nextInt(800);
						int w = rand.nextInt(200);
						int h = rand.nextInt(200);

						rectangleList.add(new Rectangle(x, y, w, h, Color.yellow, Color.yellow));
						repaint();
					} 
				}
			}
		);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

		for (Rectangle rectangle : this.rectangleList)
			rectangle.paint(g2d);

		for (Ellipse ellipse : this.ellipseList)
			ellipse.paint(g2d);
    }
}
