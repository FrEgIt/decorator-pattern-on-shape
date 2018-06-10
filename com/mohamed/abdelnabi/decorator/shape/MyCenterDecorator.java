package com.mohamed.abdelnabi.decorator.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Mohamed ABDELNABI
 */
public class MyCenterDecorator extends MyShapeDecorator{
    
    private int crossRadius;
    private Color crossColor;

    public MyCenterDecorator(int crossRadius, Color crossColor, MyShape decorated) {
        super(decorated);
        this.crossRadius = crossRadius;
        this.crossColor = crossColor;
    }

    
    @Override
    protected void drawDecoration(Graphics g) {
        int N = getNumberOfPoints(); 
        Point[] polygon;
        
        if(N==2){ // case of a polygon with 4 point           
            polygon = new Point[4];
            Point point0 = getPoint(0);
            Point point1 = getPoint(1);
            
            int widthAbs = (point0.x - point1.x )<0 ? (-(point0.x - point1.x )) : (point0.x - point1.x );
        int x = point0.x <= point1.x ? point0.x : point1.x;
        int heigthAbs = (point0.y - point1.y )<0 ? (-(point0.y - point1.y)) : (point0.y - point1.y);
        int y = point0.y <= point1.y ? point0.y : point1.y;
            
            Point r0=new Point();
            Point r1=new Point();
            Point r2=new Point();
            Point r3=new Point();
            
            r0.x = x;
            r0.y =y;
            
            r1.x = x;
            r1.y = y+heigthAbs;
            
            r2.x = x+widthAbs;
            r2.y = y+heigthAbs;
            
            r3.x = x + widthAbs;
            r3.y = y ;
             
            N=4;
            polygon[0]=r0;
            polygon[1]=r1;
            polygon[2]=r2;
            polygon[3]=r3;
            
        }else{
            polygon = new Point[N];
            for (int i = 0; i < N; i++) {
                polygon[i]=getPoint(i);
            }
        }
        
        
        Point center = pointCenter(polygon, N);
        
        getDecorated().draw(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(crossColor);
        
        
        g2.drawLine(center.x-crossRadius, center.y, center.x+crossRadius, center.y);
        g2.drawLine(center.x, center.y-crossRadius, center.x, center.y+crossRadius);
    
    }

    @Override
    public int getNumberOfPoints() {
        return getDecorated().getNumberOfPoints();
    }

    @Override
    public Point getPoint(int index) {
        return getDecorated().getPoint(index);
    }

    
    public static Point pointCenter(Point[] polygon, int N) {
                double cx = 0, cy = 0;
                int i, j;
		double area = 0;

		for (i = 0; i < N; i++) {
			j = (i + 1) % N;
			area += polygon[i].x * polygon[j].y;
			area -= polygon[i].y * polygon[j].x;
		}

		area /= 2.0;
		area = Math.abs(area);    
        
		double factor = 0;
		for (i = 0; i < N; i++) {
			j = (i + 1) % N;
			factor = (polygon[i].x * polygon[j].y - polygon[j].x * polygon[i].y);
			cx += (polygon[i].x + polygon[j].x) * factor;
			cy += (polygon[i].y + polygon[j].y) * factor;
		}
		factor = 1.0 / (6.0 * area);
		cx *= factor;
		cy *= factor;
		return new Point((int) Math.abs(Math.round(cx)), (int) Math.abs(Math
				.round(cy)));
    }
    
    
    
}
