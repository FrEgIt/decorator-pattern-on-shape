package com.mohamed.abdelnabi.decorator.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Mohamed ABDELNABI
 */
public class MyRectangle implements MyShape{
    
    private final int NUMBER_OF_POINTS = 2; 
    
    private Color fillColor;
    private Point point0, point1;

    public MyRectangle(Color fillColor, Point point0, Point point1) {
        this.fillColor = fillColor;
        this.point0 = point0;
        this.point1 = point1;
    }

    @Override
    public void draw(Graphics g) {
        
        int widthAbs = (point0.x - point1.x )<0 ? (-(point0.x - point1.x )) : (point0.x - point1.x );
        int x = point0.x <= point1.x ? point0.x : point1.x;
        int heigthAbs = (point0.y - point1.y )<0 ? (-(point0.y - point1.y)) : (point0.y - point1.y);
        int y = point0.y <= point1.y ? point0.y : point1.y;
        
        Graphics2D g2 = (Graphics2D) g;
    

        g2.setPaint(fillColor);
    
        g2.fill(new Rectangle2D.Double(x, y, widthAbs, heigthAbs));
    
        
    }

    @Override
    public int getNumberOfPoints() {
       return NUMBER_OF_POINTS;
    }

    @Override
    public Point getPoint(int index) {
        return index == 0 ?  point0 : index == 1 ? point1 : null;
    }
    
    
    
     
}
