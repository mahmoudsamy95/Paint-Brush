package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

    public Line(int x1, int y1, int x2, int y2, int currentColor, boolean currentStat) {
        super(x1, y1, x2, y2, currentColor, currentStat);
    }

    public Line() {
    }

    @Override
    public void drawShape(Graphics g) {
        switch (getCurrentColor()) {
            case 1:
                g.setColor(Color.red);
                break;
            case 2:
                g.setColor(Color.GREEN);
                break;
            case 3:
                g.setColor(Color.BLUE);
                break;
            default:
                g.setColor(Color.BLACK);
                break;
        }
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }

}
