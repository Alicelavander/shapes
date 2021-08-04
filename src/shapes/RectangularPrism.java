package shapes;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class RectangularPrism extends JFrame implements Shape {
    double side1;
    double side2;
    double height;
    @Override
    public String getName() {
        return "Rectangular prism";
    }

    @Override
    public boolean question(Scanner scanner) {
        System.out.println("What is the length of side1?");
        String value = scanner.next();
        try{
            double d = Double.parseDouble(value);
            side1 = d;
            System.out.println("What is the length of side2?");
            value = scanner.next();
            d = Double.parseDouble(value);
            side2 = d;
            System.out.println("What is the length of the height?");
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
        return this.side1 * this.side2 * this.height;
    }

    @Override
    public void getDisplay() {
        System.out.println("The volume of the rectangular prism is " + calculate() + " cubic units.");
        new RectangularPrism();
        setVisible(true);
    }

    RectangularPrism() {
        int appWidth = 300;
        int appHeight = 200;
        setSize(appWidth, appHeight);
        setTitle("Rectangular prism");
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(50, 50, (int)this.side1, (int)this.side2);
        g.drawRect(50 + (int)this.height/2, 50 + (int)this.height/2, (int)this.side1, (int)this.side2);
        g.drawLine(50, 50, 50 + (int)this.height/2, 50 + (int)this.height/2);
        g.drawLine(50, 50 + (int)this.side2, 50 + (int)this.height/2, 50 + (int)this.height/2 + + (int)this.side2);
        g.drawLine(50 + (int)this.side1, 50, 50 + (int)this.height/2 + (int)this.side1, 50 + (int)this.height/2);
        g.drawLine(50 + (int)this.side1, 50 + (int)this.side2, 50 + (int)this.height/2 + (int)this.side1, 50 + (int)this.height/2 + (int)this.side2);
    }
}
