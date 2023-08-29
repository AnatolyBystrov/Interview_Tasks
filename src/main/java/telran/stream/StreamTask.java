package telran.stream;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTask {

    private static final int minNumber = 0;
    private static final int maxNumber = Integer.MAX_VALUE;
    private static final int number_Of_Elements = 1_000_000;

    public static void printDigitStatistics()
    {
        List<Integer> array =  getRandomGroup();
        Map <Integer, Long> map = array.stream()
                .flatMapToInt(number -> String.valueOf(number).chars())
                .mapToObj(elem-> elem - '0')
                .collect(Collectors.groupingBy(num-> num,Collectors.counting()));
        map.entrySet().stream()
                .sorted((num1,num2) -> Long.compare(num2.getValue(), num1.getValue()))
                .forEach( elem-> System.out.printf("%s : %d\n", elem.getKey(), elem.getValue()));
    }

    private static List<Integer> getRandomGroup() {
        return new Random()
                .ints(minNumber,maxNumber)
                .boxed()
                .limit(number_Of_Elements)
                .toList();
    }
}
