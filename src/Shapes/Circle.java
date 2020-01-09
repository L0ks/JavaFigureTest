package Shapes;
import java.awt.*;
import java.util.Random;

public class Circle extends Shape {

    private double radius;

    public Circle(String color, Color drawColor ,double radius) {
        super(color, drawColor);
        this.radius = radius;
        double area = Math.PI * Math.pow(radius, 2);
        setArea(area);
    }


    public double getRadius(){ return radius; }

    @Override
    public void getValues() {
        System.out.println(
                "Shape: circle, " +
                        "area: " + getArea() + " square units, " +
                        "radius: " + getRadius() + " units, " +
                        "Color: " + getColor()
        );
    }

    @Override
    public void drawShape(Graphics g) {
        Random rng = new Random();
        int x = rng.nextInt(550) + 100;
        int y = rng.nextInt(250) + 100;


        g.setColor(getColorVal());
        g.fillOval(x,y,(int) radius,(int) radius);
        g.setColor(getColorVal());
        g.fillOval(x,y,(int) radius,(int) radius);
    }
}
