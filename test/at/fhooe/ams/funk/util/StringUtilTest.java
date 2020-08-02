package at.fhooe.ams.funk.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {

  @Test
  void getSimpleLetterFromAlphabet() {
    String expectedLetter = "A";
    String actualLetter = StringUtil.getAlphabetLetter(0);
    Assertions.assertEquals(expectedLetter, actualLetter);
  }

  @Test
  void getLastLetterFromAlphabet() {
    String expectedLetter = "Z";
    String actualLetter = StringUtil.getAlphabetLetter(25);
    Assertions.assertEquals(expectedLetter, actualLetter);
  }

  @Test
  void exceedLetterRangeShouldReturnB() {
    String expectedLetter = "B";
    String actualLetter = StringUtil.getAlphabetLetter(27);
    Assertions.assertEquals(expectedLetter, actualLetter);
  }

}
