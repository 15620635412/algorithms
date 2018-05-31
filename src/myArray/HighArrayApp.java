package myArray;

public class HighArrayApp {
    public static void main(String[] args) {
        HighArray ha = new HighArray(100);
        for(int i = 0; i < 10; i ++) {
            ha.insert(i);
            ha.insert(i);
        }
        ha.display();
        System.out.println("size:" + ha.size());
        System.out.println("max:" + ha.getMax());
        ha.deleteAll(9);
        ha.display();
        System.out.println("size:" + ha.size());
        System.out.println("max:" + ha.getMax());
        if (ha.find(9))
            System.out.println("find it");
    }
}
