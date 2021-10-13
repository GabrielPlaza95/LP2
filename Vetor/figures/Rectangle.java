package figures;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.lang.Math;

public class Rectangle extends Figure {
	Rectangle2D.Float rect; 	

    public Rectangle(int x, int y, int w, int h, Color border, Color fill) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.borderColor = border;
		this.fillColor = fill;

		this.rect = new Rectangle2D.Float();
    }

    void print() {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

	public void paint(Graphics2D g2d) {
		this.rect.x = Math.min(this.x, this.x + this.w);
		this.rect.y = Math.min(this.y, this.y + this.h);
		this.rect.width = Math.abs(this.w);
		this.rect.height = Math.abs(this.h);

		g2d.setColor(this.fillColor);
		g2d.fill(rect);

        g2d.setPaint(this.borderColor);
		g2d.draw(rect);
	}
	
	public boolean clicked (int x, int y) {
		return this.rect.contains(x, y);
	}
}

