package day4;

import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Constants.DOUBLE_RETURN_REGEX;
import static util.Util.convertFileToString;

@Data
public class Passport {

    String byr;
    String iyr;
    String eyr;
    String hgt;
    String hcl;
    String ecl;
    String pid;
    String cid;
    Boolean validPassport;

    public static Passport createPassportObj(String passport) {

        Passport newPassport = new Passport();
        newPassport.setByr(findValueFromString("byr", passport));
        newPassport.setIyr(findValueFromString("iyr", passport));
        newPassport.setEyr(findValueFromString("eyr", passport));
        newPassport.setHgt(findValueFromString("hgt", passport));
        newPassport.setHcl(findValueFromString("hcl", passport));
        newPassport.setEcl(findValueFromString("ecl", passport));
        newPassport.setPid(findValueFromString("pid", passport));
        newPassport.setCid(findValueFromString("cid", passport));
        newPassport.setValidPassport(true);

        return newPassport;
    }

    public static List<Passport> createPassportObjectsFromFile(String path) throws IOException {
        String[] passportStrings = convertFileToString(path).split(DOUBLE_RETURN_REGEX);
        List<Passport> passports = new ArrayList<>();
        for (String passport : passportStrings) {
            passports.add(createPassportObj(passport));
        }
        return passports;
    }

    private static String findValueFromString(String entity, String input) {
        Matcher m = Pattern.compile(entity + ":([^\\s:]+)").matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }

}
