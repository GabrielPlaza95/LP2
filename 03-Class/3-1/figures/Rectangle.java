package figures;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rectangle {
    int x, y, w, h;
	Color borderColor, fillColor;

    public Rectangle(int x, int y, int w, int h, Color border, Color fill) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.borderColor = border;
		this.fillColor = fill;
    }

    void print() {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

	void drag(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public void paint(Graphics2D g2d) {
		g2d.setColor(this.fillColor);
		g2d.fillRect(this.x, this.y, this.w, this.h);

        g2d.setPaint(this.borderColor);
		g2d.drawRect(this.x, this.y, this.w, this.h);
	}
}

