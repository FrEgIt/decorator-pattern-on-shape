package com.mohamed.abdelnabi.decorator.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Mohamed ABDELNABI
 */
public class Main {
 
    
    public static void main(String args []) 
	{
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		JFrame frame = new JFrame("Decorated shapes ");
		MyShapePanel panel = new MyShapePanel();
                panel.setPreferredSize(new Dimension(300,300));
                frame.setLocation(dim.width/2-300/2, dim.height/2-300/2);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().add( panel );
		frame.pack(); frame.setVisible( true );

		MyShape shape0 = new MyBorderDecorator(5, Color.red ,
							new MyRectangle(Color.green ,
								new Point(20, 20), new Point (120 , 60) ));
                    
		
		MyShape shape1 = new MyCenterDecorator(7, Color.black ,
							new MyRectangle(Color.cyan ,
								new Point(150 , 90), new Point (250 , 30) ));
		
		MyShape shape2 = new MyCenterDecorator(7, Color.black ,
							new MyBorderDecorator (5, Color.red ,
								new MyPolygon(Color.orange ,
									new Point(120 , 200) , new Point (250 , 170) ,
										new Point(200 , 120) , new Point (100 , 100) ,
											new Point( 50, 150) )));
		
		panel.add( shape0 );

		panel.add( shape1 );

		panel.add( shape2 );
	}
    
    
    
    
    
}
