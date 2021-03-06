package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Triangle extends Figure {
	private Polygon poly;

    public Triangle(int x, int y, int w, int h, Color border, Color fill) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.borderColor = border;
		this.fillColor = fill;

		this.poly = null;
    }

    public void print() {
        System.out.format("Triângulo retângulo de catetos (%d,%d) na posição (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

	public void paint(Graphics2D g2d) {
		int x[] = {this.x, this.x, this.x + this.w};
		int y[] = {this.y, this.y + this.h, this.y};

		this.poly = new Polygon(x, y, 3);

		g2d.setColor(this.fillColor);
		g2d.fill(poly);

        g2d.setPaint(this.borderColor);
		g2d.draw(poly);
	}
	
	public boolean clicked (int x, int y) {
		return this.poly.contains(x, y);
	}
}

