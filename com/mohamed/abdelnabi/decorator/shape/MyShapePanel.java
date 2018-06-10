package com.mohamed.abdelnabi.decorator.shape;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Mohamed ABDELNABI
 */
public class MyShapePanel extends JPanel{
 
    private ArrayList<MyShape> shapes;

    public MyShapePanel() {
        this.shapes = new ArrayList<>();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (MyShape shape : shapes) {
            shape.draw(g);
        }
    }
    
    public void add(MyShape myShape){
        this.shapes.add(myShape);
    }

    
    public ArrayList<MyShape> getShapes() {
        return shapes;
    }

}
