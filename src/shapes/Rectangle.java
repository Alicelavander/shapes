package shapes;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Rectangle extends JFrame implements Shape{
    double side1;
    double side2;
    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public boolean question(Scanner scanner) {
        System.out.println("What is the length of side 1?");
        String value = scanner.next();
        try{
            double d = Double.parseDouble(value);
            side1 = d;
            System.out.println("What is the length of side 2?");
            value = scanner.next();
            d = Double.parseDouble(value);
            side2 = d;
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public double calculate() {
        return this.side1 * this.side2;
    }

    @Override
    public void getDisplay() {
        System.out.println("The area of the rectangle is " + calculate() + " square units.");
        new Rectangle();
        setVisible(true);
    }

    Rectangle() {
        int appWidth = 300;
        int appHeight = 200;
        setSize(appWidth, appHeight);
        setTitle("Rectangle");
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(50, 50, (int)this.side1, (int)this.side2);
    }
}
