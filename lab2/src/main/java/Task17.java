/*
    Сформируйте из массива a массив b по следующему алгоритму:
    элемент массива b равен значению разности
    между максимальным значением элементов массива a и значением данного элемента массива a.
*/

import java.util.Arrays;
import java.util.Collections;

public class Task17 {

    public static void Execute()
    {
        Integer a[] = {5, 7, 8, 8, 2};
        Integer b[] = arrayTransform(a);

        System.out.println("TASK 17");
        System.out.println("Original array a: " + Arrays.toString(a));
        System.out.println("Output array b: " + Arrays.toString(b) + "\n");
    }

    public static Integer[] arrayTransform(Integer[] arr)
    {
        int max = Collections.max(Arrays.asList(arr));
        Integer newArr[] = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++)
        {
            newArr[i] = max - arr[i];
        }
        return newArr;
    }
}
