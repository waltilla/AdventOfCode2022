package day3;

import java.util.*;
import java.util.stream.Collectors;

public class Day3Answer {

    public static void main(String[] args) {

        Map<String, String > backpack = new LinkedHashMap<>();

        for (String s : Day3Data.get()) {
            int lengthOfPocket = s.length();
            String end = s.substring(lengthOfPocket / 2);
            String front = s.substring(0, lengthOfPocket/2);
            System.out.println(front);
            System.out.println("   ");
            System.out.println(end);
            backpack.put(front, end);
        }

        int sum = backpack.entrySet().stream()
                .map(s -> checkTheCommonItem(s.getKey(), s.getValue()))
                .map(d -> itemPrioValue(d))
                .collect(Collectors.toList()).stream().mapToInt(Integer::intValue).sum();

        System.out.println("sum: " + sum);


        int summ = 0;

        for (int i = 0; i < Day3Data.get().size(); i+=3) {

            String test = test(
                    Day3Data.get().get(i),
                    Day3Data.get().get(i + 1),
                    Day3Data.get().get(i + 2)
            );

            summ += itemPrioValue(test);

        }

        System.out.println(summ);

    }

    public static String checkTheCommonItem(String first, String secound){

        String f = first;
        String s = secound;
        String commonItem = "";

        for (String a : f.split("")   ) {
            for (String b: s.split("")) {
                if (a.equals(b)){
                    commonItem = a;
                }

            }
        }
        System.out.println(commonItem);
        return commonItem;
    }

    public static String test(String a, String b, String c){


        for (String  s :      a.split(""))
       {
            if(b.contains(s) && c.contains(s))
                return s ;
        }
        return "fail";

    }


    public static Integer itemPrioValue(String letter){

        int value = (int) letter.charAt(0);

        if(value >= 97){
            value -= 96;
        } else{
            value -= 64;
            value += 26;
        }
        return Integer.valueOf(value);
    }
    public static String get(){

        return
                        "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                        "PmmdzqPrVvPwwTWBwg\n" +
                        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                        "ttgJtRGJQctTZtZT\n" +
                        "CrZsJsPPZsGzwwsLwLmpwMDw";


    }

}
