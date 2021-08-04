package shapes;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Circle extends JFrame implements Shape{
    double radius;
    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public boolean question(Scanner scanner) {
        System.out.println("What is the length of the radius?");
        String value = scanner.next();
        try{
            double d = Double.parseDouble(value);
            radius = d;
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public double calculate() {
        return this.radius * Math.PI;
    }

    @Override
    public void getDisplay() {
        System.out.println("The area of the circle is " + calculate() + " square units.");
        new Circle();
        setVisible(true);
    }

    Circle() {
        int appWidth = 300;
        int appHeight = 200;
        setSize(appWidth, appHeight);
        setTitle("Circle");
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(50, 50,  (int)this.radius, (int)this.radius);
    }
}
