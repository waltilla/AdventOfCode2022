package day1;

import java.util.*;
import java.util.stream.Collectors;

public class Day1Answer {

    public static void main(String[] args) {
        
        OptionalInt bestElf = Arrays.stream(Day1Data.get().split("\n\n"))
                .map(s -> s.split("\n"))
                .map(d -> Arrays.stream(d).mapToInt(Integer::parseInt).sum())
                .collect(Collectors.toList())
                .stream().mapToInt(v -> v)
                .max();

        // get the best elf
        System.out.println(bestElf.getAsInt());

        int topThreeElfs = Arrays.stream(Day1Data.get().split("\n\n"))
                .map(s -> s.split("\n"))
                .map(d -> Arrays.stream(d).mapToInt(Integer::parseInt).sum())
                .collect(Collectors.toList())
                .stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
                .stream().limit(3).mapToInt(Integer::intValue).sum();

        // get top 3 elfs sum
        System.out.println(topThreeElfs);
    }

}
