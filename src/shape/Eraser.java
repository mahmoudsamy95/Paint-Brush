package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Eraser extends Rectangle {

    public Eraser() {
    }

    public Eraser(int x1, int y1, int x2, int y2, int currentColor, boolean currentStat) {
        super(x1, y1, x2, y2, currentColor, currentStat);
    }

    @Override
    public void drawShape(Graphics g) {
        g.fillOval(getX1(), getY1(),25, 25);
        g.setColor(Color.WHITE);
    }
}
