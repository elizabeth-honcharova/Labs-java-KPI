// Создайте базовый класс Книга (название, автор(ы), год издания, тираж, кол-во страниц).
// Производный класс – Книга в библиотеке (инвентарный номер, кто взял).

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task31 {

    public static void main(String[] args) {

        String title, author, tooker;
        int publishingYear, edition, numOfPages;
        Scanner in = new Scanner(System.in);
        Book test1 = new Book();
        try {
            System.out.print("Enter title: ");
            title = in.nextLine();
            System.out.print("Enter author: ");
            author = in.nextLine();
            System.out.print("Enter name of person who took the book: ");
            tooker = in.nextLine();
            test1.setTitle(title);
            test1.setAuthors(author);
            System.out.print("Enter year of publishing: ");
            publishingYear = in.nextInt();
            System.out.print("Enter year of edition: ");
            edition = in.nextInt();
            System.out.print("Enter year of numOfPages: ");
            numOfPages = in.nextInt();
            LibraryBook test2 = new LibraryBook(title, publishingYear, edition, numOfPages, tooker, author);
            System.out.println(test2.toString());
            System.out.println(test2.equals(test1));
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input error. Try again");
        }catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
