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
	ArrayList<Figure> figureList;

    public Hello2DFrame () {
		Random rand = new Random();

        this.setTitle("Java2D");
        this.setSize(1000, 1000);
        this.setVisible(true);
		this.getContentPane().setBackground(Color.white);

		this.figureList = new ArrayList<Figure>();

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
						int w = rand.nextInt(150) + 50;
						int h = rand.nextInt(150) + 50;

						figureList.add(new Ellipse(x, y, w, h, Color.pink, Color.pink));
						repaint();
					} 

					if (evt.getKeyChar() == 'r') {
						int x = rand.nextInt(800);
						int y = rand.nextInt(800);
						int w = rand.nextInt(150) + 50;
						int h = rand.nextInt(150) + 50;

						figureList.add(new Rectangle(x, y, w, h, Color.yellow, Color.yellow));
						repaint();
					} 

					if (evt.getKeyChar() == 't') {
						int x = rand.nextInt(800);
						int y = rand.nextInt(800);
						int w = rand.nextInt(150) + 50;
						int h = rand.nextInt(150) + 50;

						figureList.add(new Triangle(x, y, w, h, Color.blue, Color.blue));
						repaint();
					} 
				}
			}
		);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

		for (Figure figure: this.figureList)
			figure.paint(g2d);
    }
}
