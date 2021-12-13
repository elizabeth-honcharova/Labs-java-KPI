// Создайте приложение для изменения абонента телефонной сети.
// Список абонентов (5 записей) создается в программе и является объектом класса HashMap.
// Ключом записи является номер телефона (типа Integer),
// а значением – объект Abonent, содержащий четыре значения типа String:  фамилию, имя, отчество и адрес.
// Предусмотреть возможность сортировки по фамилии с помощью ArrayList.

import java.util.HashMap;
import java.util.Scanner;

public class Task13 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        HashMap<Integer, Abonent> subs = new HashMap<>();
        PhoneBook2 ph;
        Integer phone;
        String toEdit, edition;
        Abonent abonent;

        try {

            for (int i = 1; i <= 2; i++) {

                System.out.println("Abonent " + i);
                System.out.println("Input phone number, surname, name, patronymic and adress (separeted by enter): ");
                subs.put(Integer.parseInt(in.nextLine()), new Abonent(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine()));
            }

            ph = new PhoneBook2(subs);
            System.out.println("PhoneBook: ");
            PhoneBook2.print(ph);

            System.out.println("Enter the phone number of the person you want to edit: ");
            phone = in.nextInt();
            System.out.println("What do you want to edit? (surname, name, patronymic, address):" );
            in.nextLine();
            toEdit = in.nextLine();
            System.out.println("Enter new data: ");
            edition = in.nextLine();

            abonent = ph.getAbonent(phone);

            if(toEdit.equals("surname"))
                abonent.setSurname(edition);
            else if(toEdit.equals("name"))
                abonent.setName(edition);
            else if(toEdit.equals("patronymic"))
                abonent.setPatronymic(edition);
            else if(toEdit.equals("address"))
                abonent.setAddress(edition);

            System.out.println("\nPhoneBook: ");
            PhoneBook2.print(ph);
            System.out.println("Sorted by surname: ");
            PhoneBook2.print(PhoneBook2.sortBySurname(ph));
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
