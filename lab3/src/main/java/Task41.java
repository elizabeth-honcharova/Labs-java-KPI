/*
    Преобразование аргументов, задаваемых при запуске программы.
    Программа определяет тип аргумента – шестнадцатеричное число без знака
    (шаблон: шестнадцатеричным числом без знака считается строка,
    которая содержит цифры от 0 до 9 и буквы A(a), B(b), C(c), D(d), E(e),F(f)) или строка.
    Введенные аргументы-числа преобразуются в десятичные числа
    Программа выводит количество заданных аргументов, их значения,
    а также количество аргументов-чисел и их десятичные значения.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;


public class Task41 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Invalid number of arguments");
            return;
        }
        HashMap<String, List<String>> argTypes = analyseArguments(args);

        System.out.println("TASK 41");
        System.out.println("Number of arguments: " + args.length);
        for (var item : args) {
            System.out.print(item);
        }
        System.out.println("\nNumber of hex-arguments: " + argTypes.get("Hex").size());
        for (var value : argTypes.get("Hex")) {
            System.out.printf("Hex: %s\tDecimal: %d\n", value, Integer.parseInt(value, 16));
        }
    }
    public static HashMap<String, List<String>> analyseArguments(String[] args)
    {
        HashMap<String, List<String>> typesArgs = new HashMap<>();
        typesArgs.put("Hex",new ArrayList<>());
        typesArgs.put("String",new ArrayList<>());

        for (int i = 0; i < args.length; i++) {
            if (Pattern.matches("[0-9A-Fa-f]+", args[i])) {
                typesArgs.get("Hex").add(args[i]);
            } else {
                typesArgs.get("String").add(args[i]);
            }
        }
        return typesArgs;
    }
}
