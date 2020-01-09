package Shapes;

import java.awt.*;
import java.util.Random;

public class Square extends Shape {
    double side;

    public Square(String color, Color drawColor, double side) {
        super(color, drawColor);
        this.side = side;
        double area = Math.pow(side, 2);
        setArea(area);
    }

    public double getSide(){return side;}

    @Override
    public void getValues() {
        System.out.println(
                "Shape: square, " +
                        "area: " + getArea() + " square units, " +
                        "side length: " + getSide() + " units, " +
                        "Color: " + getColor()
        );
    }

    @Override
    public void drawShape(Graphics g) {
        Random rng = new Random();
        int x = rng.nextInt(550) + 100;
        int y = rng.nextInt(250) + 100;




        g.setColor(getColorVal());
        g.fillRect(x,y,(int) side,(int) side);
        g.setColor(getColorVal());
        g.drawRect(x,y,(int) side,(int) side);
    }
}
