package day2;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static util.Constants.*;
import static util.Util.createStringListFromFile;

@Slf4j
public class Day2 {

    public static void main(String[] args) {
        List<String> input = createStringListFromFile(DAY_TWO_FILE_PATH);
        log.info(PART_ONE_STRING, dayTwoPartOne(input));
        log.info(PART_TWO_STRING, dayTwoPartTwo(input));
    }

    private static AtomicInteger dayTwoPartOne(List<String> input) {
        AtomicInteger counter = new AtomicInteger();
        input.forEach(x -> {
            String[] items = x.split(" ");
            int minVal = Integer.valueOf(items[0].split("-")[0]);
            int maxVal = Integer.valueOf(items[0].split("-")[1]);
            char letter = items[1].charAt(0);
            String password = items[2];
            long count = password.chars().filter(ch -> ch == letter).count();

            if (minVal <= count && count <= maxVal) {
                counter.getAndIncrement();
            }
        });
        return counter;
    }

    private static AtomicInteger dayTwoPartTwo(List<String> input) {
        AtomicInteger counter = new AtomicInteger();
        input.forEach(x -> {
            String[] items = x.split(" ");
            int minVal = Integer.valueOf(items[0].split("-")[0]) - 1;
            int maxVal = Integer.valueOf(items[0].split("-")[1]) - 1;
            char letter = items[1].charAt(0);
            String password = items[2];

            if ((password.charAt(minVal) == letter && !(password.charAt(maxVal) == letter) ||
                    (!(password.charAt(minVal) == letter) && (password.charAt(maxVal) == letter)))) {
                counter.getAndIncrement();
            }
        });
        return counter;
    }
}
