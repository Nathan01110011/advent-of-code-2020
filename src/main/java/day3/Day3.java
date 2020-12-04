package day3;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static util.Constants.*;
import static util.Util.createStringListFromFile;

@Slf4j
public class Day3 {

    public static void main(String[] args) {
        List<String> slopes = createStringListFromFile(DAY_THREE_FILE_PATH);
        log.info(PART_ONE_STRING, dayThreePartOne(slopes));
        log.info(PART_TWO_STRING, dayThreePartTwo(slopes));
    }

    private static int dayThreePartOne(List<String> slopes) {
        return slopeTraveller(slopes, 3, 1);
    }

    private static long dayThreePartTwo(List<String> slopes) {
        List<Pair> values = new ArrayList<Pair>(Arrays.asList(new Pair(1, 1), new Pair(3, 1), new Pair(5, 1), new Pair(7, 1), new Pair(1, 2)));
        List<Integer> treesHit = new ArrayList<>();
        values.forEach(x -> treesHit.add(slopeTraveller(slopes, x.x, x.y)));
        long product = treesHit.get(0);
        for (int i = 1; i < treesHit.size(); i++) {
            product = product * treesHit.get(i);
        }
        return product;
    }

    private static int slopeTraveller(List<String> slopes, int xMoves, int yMoves) {
        int x = 0;
        int counter = 0;
        for (int i = 0; i < slopes.size() - yMoves; ) {
            x = x + xMoves;
            i = i + yMoves;
            if (slopes.get(i).charAt(x % 31) == '#') {
                counter++;
            }
        }
        return counter;
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
