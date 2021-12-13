/*
    Сформировать массив b, элементами которого являются
    значения индексов элементов исходного одномерного массива a
    в порядке убывания значений элементов.
*/

import java.util.Arrays;
import java.util.Collections;

public class Task22 {

    public static void Execute()
    {
        Integer a[] = {5, 7, 8, 10, 2};
        Integer b[] = arrayTransform(a);

        System.out.println("TASK 22");
        System.out.println("Original array a: " + Arrays.toString(a));
        System.out.println("Output array b: " + Arrays.toString(b) + "\n");
    }

    public static Integer[] arrayTransform(Integer[] arr)
    {
        Integer newArr[] = new Integer[arr.length];
        Integer tempArr[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tempArr, Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                if(arr[i] == tempArr[j] && !Arrays.asList(newArr).contains(j))
                    newArr[i] = j;
            }
        }
        return newArr;
    }
}
