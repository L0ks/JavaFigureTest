package Shapes;

import java.awt.*;

public abstract class Shape {
    private String colorName;
    private Color colorValue;
    private double area;

    public Shape(String colorName, Color colorValue){
        this.colorName = colorName;
        this.colorValue = colorValue;
    }

    protected void setArea(double area){
        this.area = area;
    }

    public double getArea(){return area;}

    public String getColor() {return colorName;}

    public Color getColorVal() {return colorValue;}

    public abstract void getValues();

    public abstract void drawShape(Graphics g);
}
