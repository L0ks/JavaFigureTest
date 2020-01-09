package Shapes;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.Random;

public class Parallelogram extends Shape {
    double base;
    double height;


    public Parallelogram(String color, Color drawColor, double base, double height) {
        super(color, drawColor);
        this.base = base;
        this.height = height;

        double area = base * height;
        setArea(area);
    }

    public double getBase(){return base;}
    public double getHeight(){return height;}

    @Override
    public void getValues() {
        System.out.println("Shape: parallelogram, area: " + getArea() + " square units, " +
                "base of the parallelogram: " + getBase() + " units, " +
                "height of the parallelogram: " + getHeight() + " units, " +
                "Color: " + getColor());
    }

    @Override
    public void drawShape(Graphics g) {
        Random rng = new Random();
        int x1 = rng.nextInt(100) + 50;
        int y1 = rng.nextInt(100) + 50;

        int x2 = x1 + (int) base;
        int y2 = y1;

        int x4 = x1 + (int) base;
        int y4 = y1 + (int) height;

        int x3 = x4 + (int) base;
        int y3 = y4;

        Path2D.Double parallelogram = new Path2D.Double();


        parallelogram.moveTo(x1,y1);
        parallelogram.lineTo(x2,y2);
        parallelogram.lineTo(x3,y3);
        parallelogram.lineTo(x4,y4);
        parallelogram.closePath();

        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(getColorVal());
        g2d.fill(parallelogram);
    }
}

