/*
    Определить абсолютное значение наименьшей разности
    между двумя любыми значениями элементов исходного одномерного массива a.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Task7 {

    public static void Execute()
    {
        int[] a = {10, 6, 2, 9};
        var diffs = differences(a);

        System.out.println("TASK 7");
        System.out.println("Original array: " + Arrays.toString(a));
        System.out.println("Differences of each element: " + diffs);
        System.out.println("Absolute value of the smallest diff: " + Math.abs(Collections.min(diffs)) + "\n");
    }

    public static ArrayList<Integer> differences(int[] arr)
    {
        var diffs = new ArrayList<Integer>();

        for (int i1 = 0, i2 = arr.length - 1; i1 < arr.length; i1++, i2--)
        {
            for(int j1 = i1 + 1, j2 = i2 - 1; j1 < arr.length; j1++, j2--)
            {
                diffs.add(arr[i1] - arr[j1]);
                diffs.add(arr[i2] - arr[j2]);
            }
        }
        return diffs;
    }
}
