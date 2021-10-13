package figures.visible;

import java.awt.Graphics2D;

public interface IVisible {
	void paint (Graphics2D g);
	boolean clicked (int x, int y);
}
