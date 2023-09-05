package telran.stream;

import java.util.*;
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

    public static void printSportLotoNumbers()
    {
        //prints random 6 unique numbers from 1 to 49
        new Random().ints(1, 50)
                .limit(6)
                .distinct().forEach(n-> System.out.print(n + " "));
    }

    public  void displayOccurrences(String [] strings)
    {
        Map <String, Integer> map =  getMap(strings);
        List <Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1,e2) -> {
            int res = Long.compare(e2.getValue(), e1.getValue());
            if (res==0)
            {
                res = e1.getKey().compareTo(e2.getKey());
            }
            return res;
        });
    }

    private  Map<String, Integer> getMap(String[] strings) {
        Map <String, Integer> res =  new HashMap();
        for (String str: strings)
        {
            res.merge(str,1, Integer::sum);
        }
        return res;
    }


}
