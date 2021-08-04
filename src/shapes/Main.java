package shapes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        Map<String, Shape> shapes = new HashMap<>();
        shapes.put("1", new Circle());
        shapes.put("2", new Rectangle());
        shapes.put("3", new Triangle());
        shapes.put("4", new Cone());
        shapes.put("5", new RectangularPrism());
        shapes.put("6", new Cylinder());
        shapes.put("7", new Sphere());

        StringBuilder options = new StringBuilder("Shapes \n");
        options.append("------------ \n");
        shapes.entrySet().forEach(entry -> options.append(entry.getKey() + ". " + entry.getValue().getName() + "\n"));
        options.append("8. Exit \n");
        options.append("What kind of shape are you dealing with?");
        String answer = "";
        Scanner scan = new Scanner(System.in);
        System.out.println(options.toString());
        answer = scan.next();
        while (!answer.equals("8")) {
            Shape shape = shapes.get(answer);
            if (shape != null) {
                System.out.println("Is " + shape.getName() + " correct? (Y/N)");
                while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) answer = scan.next();

                if (answer.equalsIgnoreCase("y")) {
                    if (shape.question(scan)) {
                        shape.getDisplay();
                    }else System.out.println("Error has occurred. Please try again.");
                }
            }
            System.out.println(options);
            answer = scan.next();
        }
        System.out.println("Good bye.");
    }
}
