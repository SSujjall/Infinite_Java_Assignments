package Testings;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundGenericEx {
    public static  void addNumbersToList(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        addNumbersToList(numberList);
        System.out.println(numberList);
    }
}
