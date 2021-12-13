// Создайте приложение для поиска книг в библиотечном каталоге по заданному критерию.
// Список книг (5 записей) создается в программе и является объектом класса HashMap.
// Ключом записи является индекс ISBN книги (типа Integer),
// а значением – объект Book, содержащий наименование книги,
// фамилию, имя и отчество (ФИО) автора, издательство (все записи типа String),
// год издания (типа int) и цену книги (типа float).
// Предусмотреть возможность сортировки каталога по ФИО автора или году издания, для чего использовать ArrayList.
// Предусмотреть возможность проверки уникальности книги с помощью TreeSet.

import java.util.HashMap;
import java.util.Scanner;

public class Task17 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        HashMap<Integer, Book> catalog = new HashMap<>();
        Library lib;

        try {

            for (int i = 1; i <= 2; i++) {

                System.out.println("Book " + i);
                System.out.println("Enter ISBN index, full name of author, name of publishing house," +
                        "year of book`s publishing and price of book (separated by enter): ");
                catalog.put(Integer.parseInt(in.nextLine()), new Book(in.nextLine(), in.nextLine(),
                        Integer.parseInt(in.nextLine()), Float.parseFloat(in.nextLine())));
            }

            lib = new Library(catalog);
            System.out.println("Catalog: ");
            Library.print(lib);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
}
