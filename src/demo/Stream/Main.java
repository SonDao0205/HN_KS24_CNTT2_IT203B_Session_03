package demo.Stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        int[] array = {1,2,3,4,5};
//        IntStream stream = Arrays.stream(array);
//        Stream<Integer> stream =

        // thao tác trung gian : sorted, limit, distinct, filter, map,...

//        IntStream stream1 = stream.filter(value -> value % 2 == 0);
//        System.out.println(stream1);
        // thao tác đầu cuối : sum, foreach, count, reduce, findFirst, findAny, anyMatch, allMatch
//        OptionalDouble avg = stream1.average();
//        System.out.println("avg : " + avg.getAsDouble());


        // --------------------------------------------------------
        // tạo 1 list 1000 số nguyên ngẫu nhiên từ -200 đến 200
        List<Integer> randomList = Stream.generate(() -> new Random().nextInt(400)-200).limit(1000).toList();
        System.out.println("size : " + randomList.size());
        // 1. lọc và in các số nguyên dương ra màn hình
        System.out.println("filter : ");
        randomList.stream().filter(n -> n > 0).forEach(i -> System.out.print(i + " "));
        // 2. loại bỏ các số trùng lặp
        List<Integer> distinctList = randomList.stream().distinct().toList();
        System.out.println("\ndistinct : " + distinctList);
        System.out.println("size : " + distinctList.size());
        //3. sắp xếp các số theo thứ tự từ lớn đến bé
        System.out.println("sorted : ");
        randomList.stream().sorted(Comparator.reverseOrder()).forEach(i -> System.out.print(i + " "));
        // 4. tính min, max
        Integer min = randomList.stream().min(Comparator.comparingInt(o -> o)).get();
        Integer max = randomList.stream().max(Comparator.comparingInt(o -> o)).get();
        System.out.println("\nmin : " + min);
        System.out.println("max : " + max);
        // 5. tính tổng tất cả các phần tử
        Integer sum = randomList.stream().reduce(0, Integer::sum);
        System.out.println("sum : " + sum);
        // 6. kiểm tra giá trị n nhập vào có tồn tại trong danh sách không
        int n = 102;
        boolean isExist = randomList.stream().anyMatch(value -> value == n);
        System.out.println("số 102 có tồn tại trong list hay không : " + isExist);
        // 7. chuyển các số âm thành số đối của nó
        List<Integer> mapInteger = randomList.stream().map(num -> num < 0 ? -num : num).toList();
        System.out.println("mapInteger : " + mapInteger);
    }
}
