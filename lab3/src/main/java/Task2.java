/*
    Вывести таблицу преобразований целых десятичных чисел
    в интервале от min до max с шагом step в 16-ном представлении.
    Параметры задачи задаются как параметры командной строки.
*/

public class Task2 {

    public static void main(String[] args) {

        int min, max, step;

        try {
            min = Integer.parseInt(args[0]);
            max = Integer.parseInt(args[1]);
            step = Integer.parseInt(args[2]);
            if(min >= max || step > (min + max)) {
                System.out.println("Invalid range!");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid number of arguments! Please, enter 3 arguments next time");
            return;
        } catch (NumberFormatException e2) {
            System.out.println("Invalid type of arguments! Please, enter 3 integer numbers next time");
            return;
        }

        System.out.println("TASK 2");
        System.out.println(String.format("Decimal to hex conversion table " +
                "\n(range from %d to %d with step %d)", min, max, step));
        System.out.println(createConversionTable(min, max, step) + "\n");
    }

    public static String createConversionTable(int min, int max, int step)
    {
        int columnWidth = Integer.toString(max).length() + 3,
                tableWidth = columnWidth * 2 + 3;
        StringBuffer table = new StringBuffer(tableWidth * (4 + max/step) + 4 + max/step);
        String format = "|%1$-" + columnWidth + "d|%1$-" + columnWidth + "X|\n";

        bound(table, tableWidth);
        table.append(String.format("|%-" + columnWidth + "s|%-" + columnWidth + "s|\n", "Dec", "Hex"));
        bound(table, tableWidth);
        for(int i = min; i <= max; i+= step) {
            table.append(String.format(format, i));
        }
        bound(table, tableWidth);

        return table.toString();
    }
    public static void bound(StringBuffer table, int tableWidth)
    {
        for(int i = 0; i < tableWidth; i+= 1) {
            table.append("-");
        }
        table.append("\n");
    }
}
