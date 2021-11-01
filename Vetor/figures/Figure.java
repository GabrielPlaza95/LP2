package figures;

import figures.visible.*;
import java.io.Serializable;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.lang.Math;

public abstract class Figure implements IVisible, Serializable {
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

	public void reset(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	//public abstract boolean clicked(int x, int y);

	//public abstract void paint(Graphics2D g2d); 
}

