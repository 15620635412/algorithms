package myArray;

public class OrdArray {
    private long[] arr;
    private int nElem;

    public OrdArray(int max) {
        arr = new long[max];
        nElem = 0;
    }

    public int size() {
        return nElem;
    }

    public int find(long searchKey) {
       int start = 0;
       int end = nElem - 1;
       int curIn;
       while (true) {
           curIn = (start + end) / 2;
           if (arr[curIn] == searchKey)
               return curIn;
           else if (start > end)
               return -1;
           else {
               if (arr[curIn] > searchKey)
                   end = curIn - 1;
               else
                   start = curIn + 1;
           }
       }
    }

    public void binaryInsert(long value) {
        if (nElem == arr.length)
            throw new IndexOutOfBoundsException("array is full");
        int start = 0;
        int end = nElem - 1;
        int insertIndex = 0;
        while(start <= end) {
            int curIn = (start + end) / 2;
            if (arr[curIn] == value) {
                insertIndex = curIn;
                break;
            } else if (arr[curIn] < value) {
                start = curIn + 1;
            } else {
                end = curIn - 1;
            }
        }

        if (insertIndex == 0)
            insertIndex = start;
        for(int i = nElem; i > insertIndex; i --)
            arr[i] = arr[i - 1];
        arr[insertIndex] = value;
        nElem ++;
    }

    public void insert(long value) {
        if (nElem == arr.length)
            throw new IndexOutOfBoundsException("array is full");
        int i;
        for (i = 0; i < nElem; i ++) {
            if (arr[i] >= value)
                break;
        }

        for (int j = nElem; j > i; j--)
            arr[j] = arr[j - 1];
        arr[i] = value;
        nElem ++;
    }

    public boolean delete(long value) {
        int j = find(value);
        if (j < 0)
            return false;
        for (int i = j; i < nElem; i ++)
            arr[i] = arr[i + 1];
        nElem --;
        return true;
    }

    public boolean deleteAll(long value) {
        if (nElem == 0)
            throw new RuntimeException("array is Empty");
        int count = 0;
        int indexEnd = 0;
        for (int i = 0; i < nElem; i ++) {
            if (arr[i] == value) {
                count ++;
                indexEnd = i;
            }
        }
        if (count == 0)
            return false;
        for (int i = indexEnd + 1; i < nElem; i ++)
            arr[i - count] = arr[i];
        nElem -= count;
        return true;
    }

    public void display() {
        for (int i = 0; i < nElem; i ++)
            System.out.print(arr[i] + "\t");
        System.out.println();
    }
}
