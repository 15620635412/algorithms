package myArray;

public class HighArray {
    private long[] arr;
    private int nElem;

    public HighArray(int max) {
        arr = new long[max];
        nElem = 0;
    }

    public int size() {
        return nElem;
    }

    public void insert(long value) {
        if (nElem == arr.length)
            throw new IndexOutOfBoundsException("array is full");
        arr[nElem ++] = value;
    }

    public boolean find(long searchKey) {
        if (nElem == 0)
            throw new RuntimeException("array is Empty");
        for (int i = 0; i < nElem; i ++) {
            if (searchKey == arr[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(long value) {
        if (nElem == 0)
            throw new RuntimeException("array is Empty");
        int i;
        for (i = 0; i < nElem; i ++) {
            if (value == arr[i])
                break;
        }
        if (i == nElem)
            return false;
        for(int j = i; j < nElem; j ++) {
            arr[j] = arr[j + 1];
        }
        nElem --;
        return true;
    }

    public boolean deleteAll(long value) {
        if (nElem == 0)
            throw new RuntimeException("array is Empty");
        int count = 0;
        while(delete(value)){
            count ++;
        }
        if (count > 0)
            return true;
       return false;
    }

    public void display() {
        for(int i = 0; i < nElem; i ++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public long getMax() {
        if (nElem == 0) {
            return -1L;
        }
        long max = arr[0];
        for (int i = 0; i < nElem; i ++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
