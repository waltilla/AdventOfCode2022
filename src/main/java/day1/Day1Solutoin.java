package day1;

import java.util.*;
import java.util.stream.Collectors;

public class Day1Solutoin {


    public static void main(String[] args) {


        OptionalInt max = Arrays.stream(Day1Data.get()
                        .split("\n\n"))
                .map(s -> s.split("\n"))
                .map(d -> Arrays.stream(d).mapToInt(Integer::parseInt).sum())
                .collect(Collectors.toList())
                .stream().mapToInt(v -> v)
                .max();

        // get the best elf
        System.out.println(max.getAsInt());


        List<Integer> collect = Arrays.stream(Day1Data.get()
                        .split("\n\n"))
                .map(s -> s.split("\n"))
                .map(d -> Arrays.stream(d).mapToInt(Integer::parseInt).sum())
                .collect(Collectors.toList())
                .stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        // get top 3 elfs sum
        System.out.println(collect.get(0) + collect.get(1) + collect.get(2));
    }

}
