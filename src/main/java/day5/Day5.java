package day5;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static util.Constants.*;
import static util.Util.createStringListFromFile;

@Slf4j
public class Day5 {

    public static void main(String[] args) {
        List<String> boardingPasses = createStringListFromFile(DAY_FIVE_FILE_PATH);
        List<Integer> seatIds = new ArrayList<>();
        boardingPasses.forEach(pass -> seatIds.add(getUniqueSeatID(getMiddleValue(pass, ROW_MAX, ROW_MIN, ROW_END_CHAR, LOW_CHAR_ROW, HIGH_CHAR_ROW),
                getMiddleValue(pass, COL_MAX, COL_MIN, COL_END_CHAR, LOW_CHAR_COL, HIGH_CHAR_COL))));
        Collections.sort(seatIds);
        log.info(PART_ONE_STRING, seatIds.get(seatIds.size() - 1));
        log.info(PART_TWO_STRING, getMissingSeatNo(seatIds));
    }

    private static int getUniqueSeatID(float row, float column) {
        return (int) (row * 8 + column);
    }

    private static float getMiddleValue(String input, float startingHigh, int startingChar, int lastChar, char lowChar, char highChar) {
        float low = 0;
        float high = startingHigh;
        for (int i = startingChar; i < lastChar; i++) {
            float midValue = (high + low) / 2;
            if (input.charAt(i) == lowChar) {
                high = (int) (midValue - 0.5);
            } else if (input.charAt(i) == highChar) {
                low = (int) (midValue + 0.5);
            }
        }
        if (input.charAt(lastChar) == lowChar) {
            return low;
        } else if (input.charAt(lastChar) == highChar) {
            return high;
        } else {
            throw new RuntimeException("Unidentified char in string");
        }
    }

    private static int getMissingSeatNo(List<Integer> seatIds) {
        int previousNumber = seatIds.get(0);
        for (int i = 1; i < seatIds.get(seatIds.size() - 1); i++) {
            if (previousNumber + 1 != seatIds.get(i)) {
                return previousNumber + 1;
            } else {
                previousNumber = seatIds.get(i);
            }
        }
        return 0;
    }
}
