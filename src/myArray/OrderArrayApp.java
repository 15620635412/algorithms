package myArray;

import java.util.Arrays;
import java.util.Random;

public class OrderArrayApp {
    public static void main(String[] args) {
        OrdArray oa = new OrdArray(100);
        Random random = new Random();
        long[] arr = new long[20];
        for (int i = 0; i < 20; i ++) {
            int num = random.nextInt(10);
            arr[i] = num;
            oa.binaryInsert(num);
        }
        System.out.println(Arrays.toString(arr));
        oa.display();
        System.out.println(oa.size());
        System.out.println(oa.find(2));
        oa.deleteAll(2);
        oa.display();
        System.out.println(oa.size());
    }
}
