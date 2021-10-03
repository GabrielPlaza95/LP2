package figures;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.lang.Math;

public abstract class Figure {
    int x, y, w, h;
	Color borderColor, fillColor;

    abstract void print();

	public void setBorderColor(Color color) {
		this.borderColor = color;
	}

	public void setFillColor(Color color) {
		this.fillColor = color;
	}

	public void drag(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public void rescale(int dw, int dh) {
		this.w += dw;
		this.h += dh;
	}

	public abstract boolean hit(int x, int y);

	public abstract void paint(Graphics2D g2d); 
}

