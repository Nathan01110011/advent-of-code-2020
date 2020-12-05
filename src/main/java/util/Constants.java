package util;

public class Constants {

    // Shared
    public static String RESOURCE_PATH = "C:\\Users\\natha\\Projects\\AdventOfCode2020\\src\\main\\resources\\";
    public static String PART_ONE_STRING = "Part One Answer: {}";
    public static String PART_TWO_STRING = "Part Two Answer: {}";

    // Day One
    public static String DAY_ONE_FILE_PATH = RESOURCE_PATH + "input1.csv";

    // Day Two
    public static String DAY_TWO_FILE_PATH = RESOURCE_PATH + "input2.csv";

    // Day Three
    public static String DAY_THREE_FILE_PATH = RESOURCE_PATH + "input3.csv";

    // Day Four
    public static String DAY_FOUR_FILE_PATH = RESOURCE_PATH + "input4.txt";
    public static String DOUBLE_RETURN_REGEX = "\\n\\n";
    public static String HEIGHT_CHECK_REGEX = "([0-9]+)(cm|in)";
    public static String HAIR_COLOUR_REGEX = "^#([a-fA-F0-9]{6}$)";
    public static String EYE_COLOUR_REGEX = "^(amb|blu|brn|gry|grn|hzl|oth)$";
    public static String PASSPORT_ID_REGEX = "^\\d{9}$";

    public static int MIN_BIRTH_YEAR = 1920;
    public static int MAX_BIRTH_YEAR = 2002;
    public static int MIN_ISSUE_YEAR = 2010;
    public static int MAX_ISSUE_YEAR = 2020;
    public static int MIN_EXPIRY_YEAR = 2020;
    public static int MAX_EXPIRY_YEAR = 2030;

    // Day Five
    public static String DAY_FIVE_FILE_PATH = RESOURCE_PATH + "input5.txt";
    public static int ROW_MIN = 0;
    public static int ROW_MAX = 127;
    public static int ROW_END_CHAR = 6;
    public static int COL_MIN = 0;
    public static int COL_MAX = 7;
    public static int COL_END_CHAR = 9;
    public static char LOW_CHAR_ROW = 'F';
    public static char HIGH_CHAR_ROW = 'B';
    public static char LOW_CHAR_COL = 'L';
    public static char HIGH_CHAR_COL = 'R';

}
