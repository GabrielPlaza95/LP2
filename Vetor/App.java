import figures.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Random;

public class App {
    public static void main (String[] args) {
        Frame frame = new Frame();
    }
}

class Frame extends JFrame {
	LinkedList<Figure> figureList;
	Figure focus;
	int px, py;
	int mouseButton;

    public Frame () {
		Random rand = new Random();

        this.setTitle("Vetor");
        this.setSize(1000, 1000);
        this.setVisible(true);
		this.getContentPane().setBackground(Color.white);

		this.figureList = new LinkedList<Figure>();
		this.focus = null;
		this.px = 0;
		this.py = 0;

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
					mouseButton = event.getButton();	

					focus = null;
					for (Figure figure: figureList) {
						if (figure.clicked(point.x, point.y)) {
							focus = figure;
							px = point.x;
							py = point.y;
						}
					}
					if (focus != null) {
						figureList.remove(focus);
						figureList.add(focus);
					}
					repaint();
				}
			 
				public void mouseReleased(MouseEvent event) {
					px = 0;
					py = 0;
					mouseButton = MouseEvent.NOBUTTON;	
				}
			}
		);

		this.addMouseMotionListener (
			new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent event) {
					if (focus != null) {
						Point point = event.getPoint();
						int dx = point.x - px; px = point.x;
						int dy = point.y - py; py = point.y;
						//System.out.format("drag %d\n", mouseButton);
						switch (mouseButton)
						{
						case MouseEvent.BUTTON1:
							focus.drag(dx, dy);
							break;
						case MouseEvent.BUTTON3:
							focus.rescale(dx, dy);
							break;
						}
						repaint();
					}
				}
			}
		);

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

					if ((evt.getKeyCode() == KeyEvent.VK_DELETE || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) && focus != null) {
						figureList.remove(focus);
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
