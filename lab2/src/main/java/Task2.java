/*
    Определить значения двух наибольших и разных по значению
    элементов исходного одномерного массива a и их индексы
    (массив может содержать элементы с равными значениями,
    т.е. необходимо вывести значение и индексы элементов с максимальными значениями
    и значение второго по величине элемента,
    а также индексы всех элементов, имеющих второе по величине значение).
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Task2 {

    public static void Execute()
    {
        Integer a[] = {5, 7, 8, 8, 2};

        var maxValues = findMax(a);

        System.out.println("TASK 2");
        System.out.println("Original array: " + Arrays.toString(a));
        for (int i : maxValues.keySet())
            System.out.println("Max value: " + i + ", indexes in array: " + maxValues.get(i));
        System.out.println();
    }

    public static HashMap<Integer, ArrayList<Integer>> findMax(Integer[] arr)
    {
        Integer max1, max2 = -1;
        HashMap<Integer, ArrayList<Integer>> max_values = new HashMap<>();

        TreeSet<Integer> uniqArr = new TreeSet<>();
        uniqArr.addAll(Arrays.asList(arr));
        max1 = uniqArr.last();
        max2 = uniqArr.lower(max1);

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == max1)
                max_values.computeIfAbsent(max1, k -> new ArrayList<>()).add(i);
            else if(arr[i] == max2)
                max_values.computeIfAbsent(max2, k -> new ArrayList<>()).add(i);
        }

        return max_values;
    }
}
