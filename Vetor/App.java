import figures.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main (String[] args) {
        Frame frame = new Frame();
    }
}

class Frame extends JFrame {
	ArrayList<Figure> figureList;
	Figure focus;

    public Frame () {
		Random rand = new Random();

        this.setTitle("Java2D");
        this.setSize(1000, 1000);
        this.setVisible(true);
		this.getContentPane().setBackground(Color.white);

		this.figureList = new ArrayList<Figure>();
		this.focus = null;

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

		this.addMouseListener (
			new MouseAdapter() {
				public void mousePressed (MouseEvent event) {
					Point point = event.getPoint();
					 
					int x = point.x;
					int y = point.y;

					//System.out.printf("(%d,%d)\n", x, y);
					 
					focus = null;
					for (Figure figure: figureList) {
						if (figure.hit(x, y)) {
							//System.out.println("HIT");
							focus = figure;
							//break;
						}
					}
					repaint();
				}
			}
		);
			 
				//public void mouseReleased(MouseEvent event) {
				//}

				//public void mouseDragged(MouseEvent event) {
				//	Point p = event.getPoint();


				//}
			//}
		//);

		//this.addMouseMotionsListener (
		//	new MouseAdapter() {
		//		public void mouseDragged (MouseEvent evt) {}
		///	}
		//);

		this.addKeyListener (
			new KeyAdapter() {
				public void keyPressed (KeyEvent evt) {
					if (evt.getKeyChar() == 'e') {
						figureList.add(new Ellipse(425, 450, 150, 100, Color.black, Color.white));
						repaint();
					} 

					if (evt.getKeyChar() == 'r') {
						figureList.add(new Rectangle(425, 450, 150, 100, Color.black, Color.white));
						repaint();
					} 

					if (evt.getKeyChar() == 't') {
						figureList.add(new Triangle(425, 450, 150, 100, Color.black, Color.white));
						repaint();
					} 

					if (evt.getKeyChar() == 'l') {
						figureList.add(new Line(400, 500, 200, 0, Color.black));
						repaint();
					} 
				}
			}
		);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

		for (Figure figure: this.figureList) {
			if (figure == this.focus) figure.setBorderColor(Color.red);
			else figure.setBorderColor(Color.black); 

			figure.paint(g2d);
		}
    }
}
