import java.util.*;
import java.util.stream.Collectors;
public class stream {
    public static void main (String []args){
        List<Integer> list=List.of(1,2,3,4,5,6);
        list.stream()
            .filter(n -> n % 2 ==0)
            .map(n-> n*2)
            .filter(n-> n >= 8)
            .forEach(System.out::println);

        List<Integer> evenlist=list.stream()
                                    .filter(n -> n % 2 == 0)
                                    .collect(Collectors.toList());
        System.out.println(evenlist);

        List<Integer> nums = List.of(5, 2, 8, 1, 3);

        nums.stream()
            .sorted()
            .forEach(System.out::println);

        long evencount=evenlist.stream()
                            .count();
        List<Integer> list1=List.of(2,2,3,3,4,5,5,6,2);

        list1.stream()
            .distinct()
            .forEach(System.out::println);
    }
    
}
