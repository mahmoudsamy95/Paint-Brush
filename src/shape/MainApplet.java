package shape;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MainApplet extends Applet implements MouseListener, MouseMotionListener {

    int x1, x2, y1, y2;
    int selectedShape;
    int selectedColor;
    boolean currentStat = false;
    Image pic,img;
    String imgName;
    private Graphics g;
    
    //Array list creation.
    ArrayList<Shape> shapeArr;
    
    //Objects creation.
    Oval oval;
    Rectangle rect;
    Line line;
    Eraser eraser;
    
    
    //buttons initializations.
    Button ovalButton;
    Button rectButton;
    Button penButton;
    Button lineButton;
    Button redButton;
    Button greenButton;
    Button blueButton;
    Button eraserButton;
    Button clearAllButton;
    Button undoButton;
    Button loadImgButton;
    Checkbox filledButton;
    
  

    public void init() {
        addMouseListener(this);
        addMouseMotionListener(this);
        pic = getImage(getDocumentBase(), "WIN_20191129_20_15_41_Pro.jpg");
        
        //Array List created from parent class Shape.
        shapeArr = new ArrayList<Shape>();
        
        //Objects created from shapes classes.
        oval = new Oval();
        rect = new Rectangle();
        line = new Line();
        eraser = new Eraser();
       
        
        //Objects created from Button class.
        ovalButton = new Button("oval");
        rectButton = new Button("Rectangle");
        penButton = new Button("Pencil");
        lineButton = new Button("Line");
        redButton = new Button("Red");
        greenButton = new Button("Green");
        blueButton = new Button("Blue");
        eraserButton = new Button("Eraser");
        clearAllButton = new Button("Clear All");
        filledButton = new Checkbox("Fill Shape", currentStat);
        undoButton = new Button("Undo");
        loadImgButton = new Button("Load Image");
        
        redButton.setBackground(Color.red);
        greenButton.setBackground(Color.GREEN);
        blueButton.setBackground(Color.BLUE);
        
        
        //Button action listeners.
        ovalButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape = 1;
            }
        });

        rectButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape = 2;
            }
        });

        penButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape = 3;
            }
        });

        lineButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape = 4;
            }
        });

        eraserButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape = 5;
            }
        });

        redButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedColor = 1;
            }
        });

        greenButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedColor = 2;
            }
        });

        blueButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedColor = 3;
            }
        });

        clearAllButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                shapeArr.clear();
                switch (selectedShape) {
                    case 1:
                        oval.setX1(0);
                        oval.setY1(0);
                        oval.setX2(0);
                        oval.setY2(0);
                        break;
                    case 2:
                        rect.setX1(0);
                        rect.setY1(0);
                        rect.setX2(0);
                        rect.setY2(0);
                        break;
                    case 4:
                        line.setX1(0);
                        line.setY1(0);
                        line.setX2(0);
                        line.setY2(0);
                        break;

                }
                repaint();
            }
        });

        filledButton.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                currentStat = filledButton.getState();
            }
        });

        undoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (shapeArr.size() > 0) {
                    shapeArr.remove(shapeArr.size() - 1);
                    switch (selectedShape) {
                        case 1:
                            oval.setX1(0);
                            oval.setY1(0);
                            oval.setX2(0);
                            oval.setY2(0);
                            break;
                        case 2:
                            rect.setX1(0);
                            rect.setY1(0);
                            rect.setX2(0);
                            rect.setY2(0);
                            break;
                        case 4:
                            line.setX1(0);
                            line.setY1(0);
                            line.setX2(0);
                            line.setY2(0);
                            break;

                    }
                    repaint();
                }
            }
        });

        loadImgButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedShape = 6;
                repaint();
            }
        });
        
        
        //Adding buttons to applet.
        add(ovalButton);
        add(rectButton);
        add(penButton);
        add(lineButton);
        add(redButton);
        add(greenButton);
        add(blueButton);
        add(eraserButton);
        add(clearAllButton);
        add(undoButton);
        add(filledButton);
        add(loadImgButton);

    }
    
    
    public void paint(Graphics g) {

        for (int i = 0; i < shapeArr.size(); i++) {
            shapeArr.get(i).drawShape(g);
        }

        switch (selectedShape) {
            case 1:
                oval.setCurrentStat(currentStat);
                oval.setCurrentColor(selectedColor);
                oval.drawShape(g);
                break;
            case 2:
                rect.setCurrentStat(currentStat);
                rect.setCurrentColor(selectedColor);
                rect.drawShape(g);
                break;
            case 4:
                line.setCurrentStat(currentStat);
                line.setCurrentColor(selectedColor);
                line.drawShape(g);
                break;
            case 5:
                eraser.drawShape(g);
                break;
            case 6:
                g.drawImage(pic, 50, 50, this);
                break;

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        x2 = e.getX();
        y2 = e.getY();

        switch (selectedShape) {
            case 4:
                line.setX1(x1);
                line.setY1(y1);
                line.setX2(x2);
                line.setY2(y2);
                break;

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        x2 = e.getX();
        y2 = e.getY();

        switch (selectedShape) {
            case 1:
                oval.setX1(x1);
                oval.setY1(y1);
                break;
            case 2:
                rect.setX1(x1);
                rect.setY1(y1);
                break;
            case 3:
                line.setX1(x1);
                line.setY1(y1);
                break;
            case 4:
                line.setX1(x1);
                line.setY1(y1);
                line.setX2(x2);
                line.setY2(y2);
                break;
            case 5:
                eraser.setX1(x1);
                eraser.setY1(y1);
                break;
        }

    }
    
    
    //Saving shapes objects to ArrayList of type Shape.
    @Override
    public void mouseReleased(MouseEvent e) {
        switch (selectedShape) {
            case 1:
                shapeArr.add(new Oval(x1, y1, x2, y2, selectedColor, currentStat));
                break;
            case 2:
                shapeArr.add(new Rectangle(x1, y1, x2, y2, selectedColor, currentStat));
                break;
            case 4:
                shapeArr.add(new Line(x1, y1, x2, y2, selectedColor, currentStat));
                break;
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();

        switch (selectedShape) {
            case 1:
                oval.setX2(x2);
                oval.setY2(y2);
                break;
            case 2:
                rect.setX2(x2);
                rect.setY2(y2);
                break;
            case 3:
                line.setX2(x2);
                line.setY2(y2);
                shapeArr.add(new Line(x1, y1, x2, y2, selectedColor, currentStat));     //To save pencil movement while dragging.
                x1 = e.getX();      //To continue from the end of the previous line.
                y1 = e.getY();
                break;
            case 4:
                line.setX2(x2);
                line.setY2(y2);
                break;
                
            case 5:
                eraser.setX2(x2);
                eraser.setY2(y2);
                shapeArr.add(new Eraser(x1, y1, 25, 25, selectedColor, currentStat));   //To save eraser movement while dragging.
                x1 = e.getX();      //To continue from the end of the previous line.
                y1 = e.getY();
                break;
        }
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    
    public void update(Graphics g) {
        if (img == null) {
            img = createImage(getWidth(),getHeight());

            this.g = img.getGraphics();
        }

        this.g.setColor(getBackground());
        this.g.fillRect(0, 0, getWidth(), getHeight());

        this.g.setColor(getForeground());
        paint(this.g);
        g.drawImage(img, 0, 0, null);

    }

}
