package Shapes;

import java.awt.*;
import java.util.Random;

public class Triangle extends Shape {

    private double baseSide;
    private double perpendicularSide;
    private double hypotenuse;

    public Triangle(String color, Color drawColor, double baseSide, double perpendicularSide){
        super(color, drawColor);
        this.baseSide = baseSide;
        this.perpendicularSide = perpendicularSide;
        setHypotenuse();
        double area = (baseSide + perpendicularSide) / 2;
        setArea(area);
    }

    private void setHypotenuse(){
        hypotenuse = Math.sqrt(Math.pow(baseSide,2) + Math.pow(perpendicularSide,2));
    }

    public double getHypotenuse(){return hypotenuse;}

    @Override
    public void getValues() {
        System.out.println(
                "Shape: triangle, " +
                        "area: " + getArea() + " square units, " +
                        "hypotenuse: " + getHypotenuse() + " units, " +
                        "Color: " + getColor()
        );
    }

    @Override
    public void drawShape(Graphics g) {
        Random rng = new Random();

        int x1 = rng.nextInt(350) + 100;
        int y1 = rng.nextInt(350) + 100;

        int x2 = x1;
        int y2 = y1 + (int) baseSide;

        int x3 = x1 + (int) perpendicularSide;
        int y3 = y1;


        g.fillPolygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);

    }

}
