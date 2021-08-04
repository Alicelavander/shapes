package shapes;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Triangle extends JFrame implements Shape{
    double base;
    double height;
    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public boolean question(Scanner scanner) {
        System.out.println("What is the length of base?");
        String value = scanner.next();
        try{
            double d = Double.parseDouble(value);
            base = d;
            System.out.println("What is the length of height?");
            value = scanner.next();
            d = Double.parseDouble(value);
            height = d;
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public double calculate() {
        return this.base * this.height / 2;
    }

    @Override
    public void getDisplay() {
        System.out.println("The area of the triangle is " + calculate() + " square units.");
        new Triangle();
        setVisible(true);
    }

    Triangle() {
        int appWidth = 300;
        int appHeight = 200;
        setSize(appWidth, appHeight);
        setTitle("Triangle");
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawPolygon(new int[] {50 - (int)this.base/2, 50, 50 + (int)this.base/2}, new int[] {(int)this.height + 50, 50, (int)this.height + 50}, 3);
    }
}
