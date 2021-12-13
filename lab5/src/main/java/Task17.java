// Создать класс записной книжки (поля: имя, Ник, мобильный телефон, адрес электронной почты, Telegram-адрес).

import java.util.Scanner;

public class Task17 {

    public static void main(String[] args) {

        String name, nickname, phone, email, telegram;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = in.nextLine();
        System.out.print("Enter your nickname: ");
        nickname = in.nextLine();
        System.out.print("Enter your phone: ");
        phone = in.nextLine();
        System.out.print("Enter your email: ");
        email = in.nextLine();
        System.out.print("Enter your telegram: ");
        telegram = in.nextLine();

        try {
            Notebook test = new Notebook(name, nickname, phone, email, telegram);
            System.out.println(test.toString());
            System.out.println(test.equals(new Notebook("a", "a","a","a","a")));
        }
        catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
