package com.example.tpsnake;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class snakeEX extends Circle{
    List<Circle> tails;
    int l=0;
    Direction direction;
    public snakeEX(double d, double d1,double d2)
    {
        super(d,d1,d2);
        tails=new ArrayList<>();

    }
    public int getlength()
    {
        return l;
    }

    public void Nouriture(Circle food){
    Circle tail=end();
    food.setCenterX(tail.getCenterX());
        food.setCenterY(tail.getCenterY());
        food.setFill(Color.BLACK);
        tails.add(l++,food);
    }
    public boolean eatself(){
        for(int i=0;i<l;i++)
        {
            if(this.getCenterX()==tails.get(i).getCenterX()&&this.getCenterY()==tails.get(i).getCenterY())
                return true;
        }
        return false;
    }

    public boolean border() {
            if(this.getCenterX()<0 || this.getCenterX()>800)
                return true;
            if(this.getCenterY()<0 || this.getCenterY()>600)
                return true;
            return false;
    }
    private Circle end(){
        if(l==0)
            return this;
        return tails.get(l-1);
    }
    public void step(){
        for(int i=l-1;i>=0;i--)
        {
            if(i==0)
            {
                tails.get(i).setCenterX(getCenterX());
                tails.get(i).setCenterY(getCenterY());
            }
            else
            {
                tails.get(i).setCenterX(tails.get(i-1).getCenterX());
                tails.get(i).setCenterY(tails.get(i-1).getCenterY());
            }
        }
        if(direction==Direction.UP)
            setCenterY(getCenterY()-20);
        else if(direction==Direction.DOWN)
            setCenterY(getCenterY()+20);
        else if(direction==Direction.LEFT)
            setCenterX(getCenterX()-20);
        else if(direction==Direction.RIGHT)
            setCenterX(getCenterX()+20);

    }
    public Direction getDirection(){
        return direction;
    }
    public void setDirection(Direction direction){
        this.direction=direction;
    }

}
