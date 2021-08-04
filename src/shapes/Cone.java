package shapes;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Cone extends JFrame implements Shape {
    double radius;
    double height;
    @Override
    public String getName() {
        return "Cone";
    }

    @Override
    public boolean question(Scanner scanner) {
        System.out.println("What is the length of the radius?");
        String value = scanner.next();
        try{
            double d = Double.parseDouble(value);
            radius = d;
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
        return Math.pow(this.radius, 2) * this.height * Math.PI / 3;
    }

    @Override
    public void getDisplay() {
        System.out.print("The volume of the cone is " + calculate() + " cubic units.");
        new Cone();
        setVisible(true);
    }

    Cone() {
        int appWidth = 300;
        int appHeight = 200;
        setSize(appWidth, appHeight);
        setTitle("Cone");
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(50, 150, (int)this.radius, (int)this.radius/3);
        g.drawLine(50, 150 + (int)this.radius/6, 50 + (int)this.radius/2, 150 - (int)this.height + (int)this.radius/6);
        g.drawLine(50 + (int)this.radius, 150 + (int)this.radius/6, 50 + (int)this.radius/2, 150 - (int)this.height + (int)this.radius/6);
    }
}
