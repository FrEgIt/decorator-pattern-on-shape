package com.mohamed.abdelnabi.decorator.shape;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Mohamed ABDELNABI
 */
public interface MyShape {
    
    public void draw(Graphics g);
    
    public int getNumberOfPoints();
    
    public Point getPoint(int index);
    
    
}
