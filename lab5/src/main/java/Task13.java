// Создать класс Квадрат. Поля - сторона.
// Функции-члены вычисляют площадь, периметр, устанавливает поля и возвращают значения.
// Функции-члены установки полей класса должны проверять корректность задаваемых параметров.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task13 {

    public static void main(String[] args) {

        int side;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Enter a side: ");
            side = in.nextInt();
            Square test = new Square(side);
            System.out.println("Perimeter: " + test.getPerimeter());
            System.out.println("Square: " + test.getSquare());
            System.out.println(test.toString());
            System.out.println(test.equals(new Square(2)));
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid input error. Try again");
        }
        catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
