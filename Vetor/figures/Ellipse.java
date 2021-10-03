package figures;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.lang.Math;

public class Ellipse extends Figure {
	Ellipse2D.Float el;

    public Ellipse(int x, int y, int w, int h, Color border, Color fill) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.borderColor = border;
		this.fillColor = fill;

		this.el = new Ellipse2D.Float();
    }

    void print() {
        System.out.format("Elipse de eixos (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

	public void paint(Graphics2D g2d) {
		this.el.x = Math.min(this.x, this.x + this.w);
		this.el.y = Math.min(this.y, this.y + this.h);
		this.el.width = Math.abs(this.w);
		this.el.height = Math.abs(this.h);

		g2d.setColor(this.fillColor);
		g2d.fill(el);

        g2d.setPaint(this.borderColor);
		g2d.draw(el);
	}
	
	public boolean hit (int x, int y) {
		return this.el.contains(x, y);
	}
}

