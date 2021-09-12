package figures;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public abstract class Figure {
    int x, y, w, h;
	Color borderColor, fillColor;

    abstract void print();

	void drag(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public abstract void paint(Graphics2D g2d); 
}

