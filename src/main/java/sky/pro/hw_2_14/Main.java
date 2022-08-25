package sky.pro.hw_2_14;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        IntegerList stringList = new IntegerListImpl();
        stringList.add ("0");
        stringList.add ("1");
        stringList.add ("2");
        stringList.add ("3");
        stringList.add ("4");
        stringList.add ("5");

        stringList.add(2, "10");
        stringList.remove(1);
        System.out.println(Arrays.toString(stringList.toArray()));

        stringList.clear();
        System.out.println(stringList.size());

    }
}
