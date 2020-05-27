package shape;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    int x,y,width,height;

    public Rectangle() {
    }

    public Rectangle(int x1, int y1, int x2, int y2, int currentColor, boolean currentStat) {
        super(x1, y1, x2, y2, currentColor, currentStat);
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
        
         x = Math.min(getX1(), getX2());
         y = Math.min(getY1(), getY2());
         width = Math.abs(getX1() - getX2());
         height = Math.abs(getY1() - getY2());
         
        if (isCurrentStat() == true) {
            g.fillRect(x, y, width, height);
        } else {
            g.drawRect(x, y, width, height);
        }
    }

}
