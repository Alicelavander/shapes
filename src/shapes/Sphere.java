package shapes;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Sphere extends JFrame implements Shape {
    double radius;
    @Override
    public String getName() {
        return "Sphere";
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
        return Math.pow(this.radius, 3) * 4 / 3 * Math.PI;
    }

    @Override
    public void getDisplay() {
        System.out.println("The volume of the sphere is " + calculate() + " cubic units.");
        new Sphere();
        setVisible(true);
    }

    Sphere() {
        int appWidth = 300;
        int appHeight = 200;
        setSize(appWidth, appHeight);
        setTitle("Sphere");
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)this.getGraphics();
        super.paint(g);
        g.drawOval(50, 50, (int)this.radius, (int)this.radius);
        g.drawOval(50, 50 + (int)this.radius/2 - (int)this.radius/4/2, (int)this.radius, (int)this.radius/4);
    }
}
