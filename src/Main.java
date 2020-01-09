import Shapes.*;
import Shapes.Rectangle;
import Shapes.Shape;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class Main extends Canvas{


    public static void main(String[] args) {

        Random rng = new Random();
        List<Shape> shapes = new ArrayList<>();

      fillList(shapes, rng);

        for (Shape shape:shapes) {
            shape.getValues();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(shapes);
            }
        });
    }


    static void fillList(List<Shape> shapes, Random rng){
        for(int i = 0; i <= rng.nextInt(30) + 10; i++){
            switch (rng.nextInt(5)){
                case 0:
                    Circle circle = new Circle(
                            getColor(rng.nextInt(6)).getColorName(),
                            getColor(rng.nextInt(6)).getColor(),
                            (double) rng.nextInt(80) + 20
                    );
                    shapes.add(circle);
                    break;

                case 1:
                    Square square = new Square(
                            getColor(rng.nextInt(6)).getColorName(),
                            getColor(rng.nextInt(6)).getColor(),
                            (double) rng.nextInt(100) + 10);
                    shapes.add(square);
                    break;

                case 2:
                    Triangle triangle = new Triangle(
                            getColor(rng.nextInt(6)).getColorName(),
                            getColor(rng.nextInt(6)).getColor(),
                            (double) rng.nextInt(100) + 10,
                            (double) rng.nextInt(70) + 10);
                    shapes.add(triangle);
                    break;

                case 3:
                    Rectangle rectangle = new Rectangle(
                            getColor(rng.nextInt(6)).getColorName(),
                            getColor(rng.nextInt(6)).getColor(),
                            (double) rng.nextInt(60) + 10,
                            (double) rng.nextInt(100) + 10);
                    shapes.add(rectangle);
                    break;

                case 4:
                    Parallelogram parallelogram = new Parallelogram(
                            getColor(rng.nextInt(6)).getColorName(),
                            getColor(rng.nextInt(6)).getColor(),
                            (double) rng.nextInt(100) + 50,
                            (double) rng.nextInt(50) + 25);
                    shapes.add(parallelogram);
                    break;

                default:
                    break;
            }
        }
    }

    private static ColorResult getColor(int num){
        ColorResult resultColor = null;
        switch (num){
            case 0:
                resultColor = new ColorResult("Black", Color.BLACK);
                break;
            case 1:
                resultColor = new ColorResult("White", Color.WHITE);
                break;
            case 2:
                resultColor = new ColorResult("Yellow", Color.YELLOW);
                break;
            case 3:
                resultColor = new ColorResult("Green", Color.GREEN);
                break;
            case 4:
                resultColor = new ColorResult("Blue", Color.BLUE);
                break;
            case 5:
                resultColor = new ColorResult("Red", Color.RED);
                break;
        }


        return resultColor;
    }

    private static void createAndShowGUI(List<Shape> shapes) {
        System.out.println("Created GUI on EDT? "+
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Shape Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(750,450);
        f.add(new MyPanel(shapes));
        f.pack();
        f.setVisible(true);
    }

    static class MyPanel extends JPanel {
        List<Shape> shapes;


        public MyPanel(List<Shape> shapes) {
            this.shapes = shapes;
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        public Dimension getPreferredSize() {
            return new Dimension(750,450);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (Shape shape:shapes) {
                shape.drawShape(g);
            }
        }
    }

    static class ColorResult{
        private Color color;
        private String colorName;
        public ColorResult(String colorName,Color color){
            this.color = color;
            this.colorName = colorName;
        }

        public Color getColor() {
            return color;
        }

        public String getColorName() {
            return colorName;
        }
    }

}
