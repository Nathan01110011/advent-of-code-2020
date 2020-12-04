package day4;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static day4.Passport.createPassportObjectsFromFile;
import static util.Constants.*;

@Slf4j
public class Day4 {

    public static void main(String[] args) throws IOException {
        List<Passport> passports = createPassportObjectsFromFile(DAY_FOUR_FILE_PATH);
        log.info(PART_ONE_STRING, dayFourPartOne(passports));
        log.info(PART_TWO_STRING, dayFourPartTwo(passports));
    }

    private static long dayFourPartOne(List<Passport> passports) {
        return passports.stream().filter(Day4::isPassportValidBasicCheck).count();
    }

    private static long dayFourPartTwo(List<Passport> passports) {
        return passports.stream().filter(Day4::isPassportValidAdvancedCheck).count();
    }

    private static boolean isPassportValidBasicCheck(Passport passport) {
        if (passport.getByr() == null || passport.getIyr() == null || passport.getEyr() == null ||
                passport.getHgt() == null || passport.getHcl() == null || passport.getEcl() == null ||
                passport.getPid() == null) {
            return false;
        }
        return true;
    }

    private static boolean isPassportValidAdvancedCheck(Passport passport) {
        validYearCheck(passport, passport.getByr(), MIN_BIRTH_YEAR, MAX_BIRTH_YEAR);
        validYearCheck(passport, passport.getIyr(), MIN_ISSUE_YEAR, MAX_ISSUE_YEAR);
        validYearCheck(passport, passport.getEyr(), MIN_EXPIRY_YEAR, MAX_EXPIRY_YEAR);
        validHeightCheck(passport, passport.getHgt(), HEIGHT_CHECK_REGEX);
        simpleRegexCheck(passport, passport.getHcl(), HAIR_COLOUR_REGEX);
        simpleRegexCheck(passport, passport.getEcl(), EYE_COLOUR_REGEX);
        simpleRegexCheck(passport, passport.getPid(), PASSPORT_ID_REGEX);
        return passport.getValidPassport();
    }

    private static void validYearCheck(Passport passport, String input, int min, int max) {
        if (input != null) {
            int year = Integer.valueOf(input);
            if (!(year >= min && year <= max)) {
                passport.setValidPassport(false);
            }
        } else {
            passport.setValidPassport(false);
        }
    }

    static void simpleRegexCheck(Passport passport, String input, String regex) {
        if (input != null) {
            Matcher m = Pattern.compile(regex).matcher(input);
            if (!m.find()) {
                passport.setValidPassport(false);
            }
        } else {
            passport.setValidPassport(false);
        }
    }

    static void validHeightCheck(Passport passport, String input, String regex) {
        if (input != null) {
            Matcher m = Pattern.compile(regex).matcher(input);
            if (m.find()) {
                String unit = m.group(2);
                Integer value = Integer.valueOf(m.group(1));
                if (unit.equals("cm")) {
                    if (!(value >= 150 && value <= 193)) {
                        passport.setValidPassport(false);
                    }
                } else {
                    if (!(value >= 59 && value <= 76)) {
                        passport.setValidPassport(false);
                    }
                }
            } else {
                passport.setValidPassport(false);
            }
        } else {
            passport.setValidPassport(false);
        }
    }
}
