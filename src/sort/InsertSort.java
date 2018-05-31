package sort;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {
    /**
     * 插入排序，最大的在左边
     * @param array 数组
     */
    public static void insertSort(@NotNull long[] array) {
        if (array.length == 0)
            throw new RuntimeException("array is empty");
        int middle = array.length / 2;
        int swap = 0; //交换计数
        int compare = 0;
        //通过选择排序实现数组左边局部有序
        for(int i = 0; i < middle; i ++) {
            int maxIndex = i;
            long max = array[i];
            for (int j = i; j < middle; j ++) {
                if (array[j] > max) {
                    max = array[j];
                    maxIndex = j;
                    swap ++;
                }
                compare ++;
            }
            array[maxIndex] = array[i];
            array[i] = max;
        }
        int length = array.length;
        while(middle < length) {
            long temp = array[middle];
            for (int i = middle - 1; i >= 0; i --) {
                if (array[i] < temp)
                    array[i + 1] = array[i];
                else {
                    array[i + 1] = temp;
                    break;
                }
                compare ++;
                swap ++;
            }
            middle ++;
        }
        System.out.println("compare:" + compare + "\tswap:" + swap);
    }

    /**
     * 选择排序
     * @param array 数组
     */
    public static void selectSort(@NotNull long[] array) {
        int length = array.length;
        int swap = 0; //交换计数
        int compare = 0; //比较计数
        for(int i = 0; i < length; i ++) {
            int maxIndex = i;
            long max = array[i];
            for (int j = i; j < length; j ++) {
                if (array[j] > max) {
                    max = array[j];
                    maxIndex = j;
                }
                compare ++;
            }
            array[maxIndex] = array[i];
            array[i] = max;
            swap ++;
        }
        System.out.println("compare:" + compare + "\tswap:" + swap);
    }
    public static void main(String[] args) {
        long[] arr = new long[10];
        Random random = new Random();
        for(int i = 0; i < 10; i ++) {
            arr[i] = random.nextInt(10);
        }
        long[] arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(arr1));
        selectSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
