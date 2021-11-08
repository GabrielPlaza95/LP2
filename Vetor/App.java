import figures.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;
import java.io.*;
import java.util.Objects;

public class App {
    public static void main (String[] args) {
        Frame frame = new Frame();
    }
}

class Frame extends JFrame implements ActionListener {
	private LinkedList<Figure> figureList;
	private Figure focus;
	private int px, py;
	private int mouseButton;

	JPanel panel = new JPanel();
	JButton[] buttons = {
		new JButton("Elipse"), //, leftButtonIcon),
		new JButton("Retângulo"), //, middleButtonIcon),
		new JButton("Triângulo"), // rightButtonIcon),
		new JButton("Linha") // rightButtonIcon)
	};

	//LinkedList<ImageIcon> icons = {
	//	createImageIcon("images/ellipse.gif"),
	//	createImageIcon("images/rectangle.gif"),
	//	createImageIcon("images/triangle.gif"),
	//	createImageIcon("images/line.gif")
	//};

	@SuppressWarnings("unchecked")
    public Frame () {
        this.setTitle("Vetor");
        this.setSize(1000, 1000);

		this.figureList = new LinkedList<Figure>();

		try {
			FileInputStream f = new FileInputStream("proj.bin");
			ObjectInputStream o = new ObjectInputStream(f);
			this.figureList = (LinkedList<Figure>) o.readObject();
			o.close();
		} catch (Exception ex) {
			System.out.println("Erro ao carregar figuras");
		}

		this.setLayout(null);
		//panel.setLayout(null);
		this.setContentPane(panel);
		panel.setLocation(0,0);

		this.focus = null;
		this.px = 0;
		this.py = 0;

		buttons[0].setActionCommand("e");
		buttons[1].setActionCommand("r");
		buttons[2].setActionCommand("t");
		buttons[3].setActionCommand("l");

		buttons[0].setToolTipText("Criar Elipse");
		buttons[1].setToolTipText("Criar Retângulo");
		buttons[2].setToolTipText("Criar Triângulo");
		buttons[3].setToolTipText("Criar Linha");

		for (JButton button: this.buttons) {
			button.setBounds(50,100,95,30);  
			button.addActionListener(this);
			this.panel.add(button);  
		}

        this.setVisible(true);
		this.getContentPane().setBackground(Color.white);

        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
					try {
						FileOutputStream f = new FileOutputStream("proj.bin");
						ObjectOutputStream o = new ObjectOutputStream(f);
						o.writeObject(figureList);
						o.flush();
						o.close();
					} catch (Exception ex) {
						System.out.println("Erro ao salvar figuras");
					}
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

	public void actionPerformed (ActionEvent evt) {
		if (Objects.equals(evt.getActionCommand(), "e")) {
			figureList.add(new Ellipse(425, 450, 150, 100, Color.black, Color.white));
			repaint();
		}

		if (Objects.equals(evt.getActionCommand(), "r")) {
			figureList.add(new Rectangle(425, 450, 150, 100, Color.black, Color.white));
			repaint();
		}

		if (Objects.equals(evt.getActionCommand(), "t")) {
			figureList.add(new Triangle(425, 450, 150, 100, Color.black, Color.white));
			repaint();
		}

		if (Objects.equals(evt.getActionCommand(), "l")) {
			figureList.add(new Line(400, 500, 200, 0, Color.black));
			repaint();
		}
	}
}
