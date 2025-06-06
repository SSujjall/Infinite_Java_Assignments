package Testings;

import java.util.List;

public class UpperboundedGenericEx {
    public static double sum(List<? extends Number> numbers) {
        double sum = 0.0;
//        return numbers.stream()
//                .mapToDouble(Number::doubleValue)
//                .sum();

        for (Number x : numbers) {
            sum += x.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1,2,3,4,5);
        System.out.println(sum(integerList));

        // mathi ko generic ma List le NUmber extend gareko xa
        // so number vitra ko subclasses (like integer, float, etc) matra
        // halnu paiyo. String ko list halna paiyena.
        List<String> strList = List.of("Sujal");
//        sum(strList);
    }
}
