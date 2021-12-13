// Построить программу для работы с классом для хранения данных о кривой второго порядка - эллипсе.
// Программа должна обеспечивать простейшие функции: расчет у по х и наоборот, ввод значений, вывод значений.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double a, b, x;
        try {
            System.out.print("Enter a and b: ");
            a = in.nextDouble();
            b = in.nextDouble();
            System.out.print("Enter x: ");
            x = in.nextDouble();
            Ellipse test = new Ellipse(a, b);
            System.out.printf("y = %.2f if x = %.2f\n", test.calculateY(x), x);
            System.out.println(test.toString());
            System.out.println(test.equals(new Ellipse(2, 5)));
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid input error. Try again");
        }
    }
}
