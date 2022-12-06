package day2;

import java.util.Objects;

public class Day2Answer {

    /*
     A Y         a = rock        y = paper   2    = win = 6 = 8
     B X         b = paper       x = rock    1    = lose = 0 = 1
     C Z         c = scissors    z = scissors 3   = draw = 3 = 6
    */

    public static void main(String[] args) {
        first();
        secound();
    }

    public static void first() {
        int total = 0;
        for (String s : Day2Data.get().split("\n")) {
            String[] s1 = s.split(" ");
            total += score(s1[0], convertToSameValue(s1[1])) + handValue(convertToSameValue(s1[1]));
        }
        System.out.println(total);
    }

    public static void secound() {

        int total = 0;
        for (String s : Day2Data.get().split("\n")) {
            String[] s1 = s.split(" ");
            total += score(s1[0], counterHand(s1[0], elfSuperStrategy(s1[1]))) + handValue(counterHand(s1[0], elfSuperStrategy(s1[1])));
        }
        System.out.println(total);
    }

    public static String convertToSameValue(String hand) {
        switch (hand) {
            case "Y" -> {return "B";}
            case "X" -> {return "A";}
            default  -> {return "C";}
        }
    }

    public static Integer score(String opponent, String me) {

        if (me.equals(opponent)) {
            return 3;
        } else if (
                Objects.equals(opponent, "A") && me.equals("B") ||
                Objects.equals(opponent, "B") && me.equals("C") ||
                Objects.equals(opponent, "C") && me.equals("A")) {
            return 6;
        } else
            return 0;
    }

    public static Integer handValue(String hand) {
        int i = 0;
        switch (hand) {
            case "A" -> {
                i = 1;
            }
            case "B" -> {
                i = 2;
            }
            case "C" -> {
                i = 3;
            }
            default -> {
                i = 0;
            }
        }
        return i;
    }

    public static String elfSuperStrategy(String strat) {
        switch (strat) {
            case "X" -> {return "L";}
            case "Y" -> {return "D";}
            default ->  {return "W";}
        }
    }

    public static String counterHand(String opponent, String strat) {
        switch (strat) {
            case "L" -> {
                if (opponent.equals("A")) {
                    return "C";
                } else if (opponent.equals("B")) {
                    return "A";
                } else {
                    return "B";
                }
            }
            case "W" -> {
                if (opponent.equals("A")) {
                    return "B";
                } else if (opponent.equals("B")) {
                    return "C";
                } else {
                    return "A";
                }
            }
            default -> {
                return opponent;
            }
        }
    }
}
