package com.mohamed.abdelnabi.decorator.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Mohamed ABDELNABI
 */
public class MyPolygon implements MyShape{
    
    private Color fillColor;
    
    private ArrayList<Point> points; 
    
    public MyPolygon(Color fillColor, Point... listpoints){
        this.fillColor = fillColor;
        this.points=new ArrayList<>();
        this.points.addAll(Arrays.asList(listpoints));
        
    }
    
    
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int npoints = getNumberOfPoints();
        int xpoints[] =new int[npoints];
        int ypoints[] =new int[npoints];
        
        for (int i = 0; i < npoints; i++) {
            xpoints[i]=getPoint(i).x;
            ypoints[i]=getPoint(i).y;
        }
        
        g2.setPaint(fillColor);
        
        g2.fillPolygon(xpoints, ypoints, npoints);
        
    }

    @Override
    public int getNumberOfPoints() {
       return points.size();
    }

    @Override
    public Point getPoint(int index) {
        return points.get(index);
    }
    
    
    
}
