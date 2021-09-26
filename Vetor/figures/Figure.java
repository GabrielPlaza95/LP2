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

	void drag(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public boolean hit(int x, int y) {
		//print();
		int rx = this.w / 2;
		int ry = this.h / 2;
		return Math.abs(x - this.x - rx) <= rx
			&& Math.abs(y - this.y - ry) <= ry;
	}

	public abstract void paint(Graphics2D g2d); 
}

