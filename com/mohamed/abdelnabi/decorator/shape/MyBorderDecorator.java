package com.mohamed.abdelnabi.decorator.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Mohamed ABDELNABI
 */
public class MyBorderDecorator extends MyShapeDecorator{
    
    private int  vertexRadius;
    private Color vertexColor;

    public MyBorderDecorator(int vertexRadius, Color vertexColor, MyShape decorated) {
        super(decorated);
        this.vertexRadius = vertexRadius;
        this.vertexColor = vertexColor;
    }

    

    @Override
    protected void drawDecoration(Graphics g) {
        getDecorated().draw(g);
        Graphics2D g2 = (Graphics2D) g;
        
        System.out.println("Number of points : "+getDecorated().getNumberOfPoints());
        for (int i = 0; i < getDecorated().getNumberOfPoints(); i++) {
            
            Point p = getDecorated().getPoint(i);
            
            g2.setColor(vertexColor);
            g2.fillOval(p.x-vertexRadius, p.y-vertexRadius, vertexRadius*2, vertexRadius*2);
       
            
        }
    }

    @Override
    public int getNumberOfPoints() {
        return getDecorated().getNumberOfPoints();
    }

    @Override
    public Point getPoint(int index) {
        return getDecorated().getPoint(index);
    }
    
    
    
    
}
