package Testings;

import java.util.List;

public class UnboundGenericEx {
    public static void main(String[] args) {
        // UNBOUND EXAMPLES
//        MyClass<String> cl = new MyClass<>("Sujal");
//        System.out.println(cl.getItem());

        List<String> strList = List.of("asd", "www", "daw");
        PrintList(strList);
    }

    public static void PrintList(List<?> list) {
        list.stream()
                .toList()
                .forEach(System.out::println);
    }
}

