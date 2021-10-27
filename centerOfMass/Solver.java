package centerOfMass;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solver {
    public static Point getCenterMass(List<Mass> masses) {
        double xSum = 0;
        double ySum = 0;
        double massSum = 0;

        for (Mass mass : masses) {
            double currentMass = mass.getMass();
            Point currentPosition = mass.getPosition();

            xSum += currentMass * currentPosition.getX();
            ySum += currentMass * currentPosition.getY();
            massSum += currentMass;
        }

        double finalX = xSum / massSum;
        double finalY = ySum / massSum;
        Point result = new Point(finalX, finalY);

        return result;
    }

    public static void main(String args[]) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        List<Mass> masses = new LinkedList<>();

        while (!exit) {
            System.out.print("Enter the mass of a new object: ");
            String massString = scanner.nextLine();
            if (massString == "") {
                exit = true;
                break;
            }

            System.out.print("Enter the X coordinate for a new mass: ");
            String xCoordString = scanner.nextLine();
            if (xCoordString == "") {
                exit = true;
                break;
            }

            System.out.print("Enter the Y coordinate for a new mass: ");
            String yCoordString = scanner.nextLine();
            if (yCoordString == "") {
                exit = true;
                break;
            }

            try {
                double mass = Double.parseDouble(massString);
                double xCoord = Double.parseDouble(xCoordString);
                double yCoord = Double.parseDouble(yCoordString);

                Point massPosition = new Point(xCoord, yCoord);
                Mass newMass = new Mass(mass, massPosition);
                masses.add(newMass);
            } catch (Exception e) {
                exit = true;
            }
        }

        System.out.println(Solver.getCenterMass(masses));
        scanner.close();
    }
}
