package at.fhooe.ams.funk.util;

import java.util.Arrays;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class StringUtil {

  private static final int  CHARACTER_RANGE = 65;
  private static final int AMOUNT_OF_LETTERS = 26;

  public static String normalizeSet(String string) {
    return string.replaceAll("\\{", "").replaceAll("\\}", "");
  }

  public static String normalizeTuple(String string) {
    return string.replaceAll("\\(", "").replaceAll("\\)", "");
  }

  public static String[] trimAll(String[] string) {
    return Arrays.stream(string).map(String::trim).toArray(String[]::new);
  }

  public static String getAlphabetLetter(int i) {
    if(i >= AMOUNT_OF_LETTERS) {
      i %= AMOUNT_OF_LETTERS;
    }
    int charDigit = i  + CHARACTER_RANGE;
    char parsedChar = (char) charDigit;
    return String.valueOf(parsedChar);
  }

}
