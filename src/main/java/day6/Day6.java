package day6;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.Constants.*;
import static util.Util.convertFileToString;

@Slf4j
public class Day6 {

    public static void main(String[] args) throws IOException {
        String[] answerGroups = convertFileToString(DAY_SIX_FILE_PATH).split(DOUBLE_RETURN_REGEX);
        log.info(PART_ONE_STRING, getNumberOfAnswersAtLeastOneUserRespondedYes(answerGroups));
        log.info(PART_TWO_STRING, getNumberOfAnswersThatAllUsersRespondedAllYes(answerGroups));
    }

    private static int getNumberOfAnswersAtLeastOneUserRespondedYes(String[] answerGroups) {
        int counter = 0;
        for (String personAnswers: answerGroups) {
            personAnswers = personAnswers.replace("\n", "").replace("\r", "");
            StringBuilder sb = new StringBuilder();
            personAnswers.chars().distinct().forEach(c -> sb.append((char) c));
            counter += sb.length();
        }
        return counter;
    }

    private static int getNumberOfAnswersThatAllUsersRespondedAllYes(String[] answerGroups) {
        int counter = 0;
        for (String personAnswers: answerGroups) {
            List<Character> allAnswered = new ArrayList<>();
            int groupSize = personAnswers.split("\n").length;
            personAnswers = personAnswers.replace("\n", "").replace("\r", "");
            for (char letter: ALPHABET.toCharArray()) {
                int numberOfAnswersForThatQuestion = personAnswers.length() - personAnswers.replace(String.valueOf(letter), "").length();
                if (numberOfAnswersForThatQuestion == groupSize) {
                    allAnswered.add(letter);
                }
            }
            counter += allAnswered.size();
        }
        return counter;
    }
}
