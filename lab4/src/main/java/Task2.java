// Создайте приложение для поиска абонента телефонной сети.
// Список абонентов (5 записей) создается в программе и является объектом класса TreeMap.
// Ключом записи является номер телефона (типа String),
// а значением – объект Abonent, содержащий четыре значения типа String:  фамилию, имя, отчество и адрес.
// Предусмотреть возможность сортировки элементов коллекции по 2-3 полям.

import java.util.Scanner;
import java.util.TreeMap;

public class Task2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        TreeMap<String, Abonent> abonents = new TreeMap<>();
        PhoneBook ph;

        try {

            for (int i = 1; i <= 2; i++) {

                System.out.println("Abonent " + i);
                System.out.println("Input phone number, surname, name, patronymic and adress (separeted by enter): ");
                abonents.put(in.nextLine(), new Abonent(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine()));
            }
            ph = new PhoneBook(abonents);

            System.out.println("\nEnter the phone number of the abonent you want to find: ");
            System.out.println(ph.findAbonent(in.nextLine()));

            System.out.println("\nSorted by phones: ");
            PhoneBook.print(ph);

            System.out.println("Sorted by full name: ");
            PhoneBook.print(PhoneBook.sortBySurname(ph));
        }
        catch (IllegalArgumentException ex) {

            System.out.println("Invalid input. Try again!");
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
