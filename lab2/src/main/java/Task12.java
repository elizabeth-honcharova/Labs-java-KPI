/*
    Определить, образуют ли значения элементов исходного одномерного массива a:
    строго возрастающую последовательность (ai < ai+1),
    строго убывающую последовательность (ai > ai+1)
    или элементы массива не упорядочены и вывести для каждого случая соответствующее сообщение.
*/

import java.util.Arrays;

public class Task12 {

    public static void Execute()
    {
        Integer[] a = {10, 6, 2, 8, 1, 9};

        System.out.println("TASK 12");
        System.out.println("Original array: " + Arrays.toString(a));
        System.out.println(isSorted(a) + "\n");
    }

    public static String isSorted(Integer[] arr)
    {
        boolean isDesk = true, isAsc = true;
        String answer = "";

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                isDesk = false;
            else if (arr[i] < arr[i - 1])
                isAsc = false;

            if (!isAsc && !isDesk) {
                return "The sequence isn`t sorted";
            }
        }
        if (isAsc)
            answer = "This is an ascending sequence";
        else if (isDesk)
            answer = "This is an descending sequence";

        return answer;
    }
}
