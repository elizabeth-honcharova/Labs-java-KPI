/*
    Анализ типов аргументов, задаваемых при запуске программы.
    Если аргумент является десятичным числом с целой и дробной частью
    (шаблон: состоит из одной или нескольких цифр,
    одной десятичной точки, которая может быть в начале, в середине или в конце числа,
    и, кроме того, первым символом числа может быть знак "+" или "-"),
    то  тип аргумента "Decimal", иначе "String".
    Программа выводит количество заданных аргументов и, для каждого аргумента, его тип и значение.
*/

import java.util.regex.Pattern;

public class Task17 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Invalid number of arguments");
            return;
        }
        String[] argTypes = analyseArguments(args);

        System.out.println("TASK 17");
        System.out.println("Number of arguments: " + args.length);
        System.out.println("List of arguments: (type and value)");
        for (var item : argTypes) {
            System.out.println(item);
        }
    }
        public static String[] analyseArguments(String[] args)
        {
            String[] types = new String[args.length];

            for (int i = 0; i < args.length; i++) {
                if (Pattern.matches("^[-+]?(?:\\d+\\.\\d*|\\.\\d+)$", args[i])) {
                    types[i] = "Decimal " + args[i];
                } else {
                    types[i] = "String \"" + args[i] + "\"";
                }
            }
            return types;
        }
}