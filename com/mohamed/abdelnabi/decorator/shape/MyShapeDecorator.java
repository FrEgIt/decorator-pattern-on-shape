package com.mohamed.abdelnabi.decorator.shape;


import java.awt.Graphics;

/**
 *
 * @author Mohamed ABDELNABI
 */
public abstract class MyShapeDecorator implements MyShape{
    
    private MyShape decorated;

    public MyShapeDecorator(MyShape decorated) {
        this.decorated = decorated;
    }
    
    
    @Override
    public void draw(Graphics g){
        this.drawDecoration(g);
    }
            
    protected abstract void drawDecoration(Graphics g);

    
    
    
    
    public MyShape getDecorated() {
        return decorated;
    }

    public void setDecorated(MyShape decorated) {
        this.decorated = decorated;
    }

}
