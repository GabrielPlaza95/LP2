package figures;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Line extends Figure {
	Line2D.Float ln;

    public Line(int x, int y, int w, int h, Color border) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.borderColor = border;

		this.ln = new Line2D.Float();
    }

    void print() {
        System.out.format("Segmento de reta de (%d,%d) a (%d,%d).\n",
            this.x, this.y, this.x + this.w, this.y + this.h);
    }

	public void paint(Graphics2D g2d) {
		this.ln.x1 = this.x;
		this.ln.y1 = this.y;
		this.ln.x2 = this.x + this.w;
		this.ln.y2 = this.y + this.h;

        g2d.setPaint(this.borderColor);
		g2d.draw(ln);
	}

	public boolean clicked (int x, int y) {
		return this.ln.intersects(x - 20, y - 20, 40, 40); 
	}
}

