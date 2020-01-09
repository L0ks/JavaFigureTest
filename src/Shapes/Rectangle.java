package Shapes;

import java.awt.*;
import java.util.Random;

public class Rectangle extends Shape{
    double length;
    double width;
    double diagonal;
    double perimeter;


    public Rectangle(String color, Color drawColor, double length, double width) {
        super(color, drawColor);
        this.length = length;
        this.width = width;
        setDiagonal();
        setPerimeter();
        double area = length * width;
        setArea(area);
    }

    protected void setDiagonal(){
        diagonal = Math.sqrt(Math.pow(length,2) + Math.pow(width,2));
    }

    protected void setPerimeter(){
        perimeter = 2*(length + width);
    }

    public double getLength(){return length;}
    public double getWidth(){return width;}
    public double getDiagonal(){return diagonal;}
    public double getPerimeter(){return perimeter;}

    @Override
    public void getValues() {
        System.out.println(
                "Shape: rectangle, area: " + getArea() + " square units, " +
                "length of the rectangle: " + getLength() + " units, " +
                "width of the rectangle: " + getWidth() + " units, " +
                "diagonal of the rectangle: " + getDiagonal() + " units, " +
                "perimeter of the rectangle: " + getPerimeter() + " units, " +
                "Color: " + getColor());
    }

    @Override
    public void drawShape(Graphics g) {
        //750,450
        Random rng = new Random();
        int x = rng.nextInt(550) + 100;
        int y = rng.nextInt(250) + 100;


        g.setColor(getColorVal());
        g.fillRect(x,y,(int) width,(int) length);
        g.setColor(getColorVal());
        g.drawRect(x,y,(int) width,(int) length);
    }
}
