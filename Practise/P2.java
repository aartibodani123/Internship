import java.util.*;

public class P2 {
    public static void main(String []args){
        List<Integer> numbers=new ArrayList<>();
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);
        numbers.add(15);
        numbers.add(16);

        numbers.forEach(n -> System.out.println(n));
        numbers.stream()
               .filter(n -> n % 2 == 0)   // even numbers
               .map(n -> n * n)           // square
               .forEach(System.out::println);



    }
}
