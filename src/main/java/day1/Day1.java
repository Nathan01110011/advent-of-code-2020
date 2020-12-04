package day1;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static util.Constants.*;
import static util.Util.createIntListFromFile;

@Slf4j
public class Day1 {

    public static void main(String[] args) {
        List<Integer> input = createIntListFromFile(DAY_ONE_FILE_PATH);
        log.info(PART_ONE_STRING, dayOnePartOne(input));
        log.info(PART_TWO_STRING, dayOnePartTwo(input));
    }

    private static int dayOnePartOne(List<Integer> input) {
        for (Integer x : input) {
            for (Integer y : input) {
                if (x + y == 2020) {
                    return x * y;
                }
            }
        }
        return 0;
    }

    private static int dayOnePartTwo(List<Integer> input) {
        for (Integer x : input) {
            for (Integer y : input) {
                if (x == y) continue;
                for (Integer z : input) {
                    if (x == z || y == z) continue;
                    if ((x + y + z) == 2020) {
                        return x * y * z;
                    }
                }
            }
        }
        return 0;
    }

}
