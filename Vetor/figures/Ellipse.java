package figures;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Ellipse extends Figure {
    //int x, y, w, h;
	//Color borderColor, fillColor;
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
		this.el.x = this.x;
		this.el.y = this.y;
		this.el.width = this.w;
		this.el.height = this.h;

		g2d.setColor(this.fillColor);
		g2d.fill(el);

        g2d.setPaint(this.borderColor);
		g2d.draw(el);
	}
}

