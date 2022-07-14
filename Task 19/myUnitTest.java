import org.junit.jupiter.api.Test;

public class myUnitTest {

  @Test
  void calculateAgeTest() {
    System.out.println(calculateAge(1998));
  }

  public int calculateAge(int year) {
    if (year < 2022) {
      return 2022 - year;
    }
    else {
      System.out.println("You cannot be born passed the current year.");
      return 0;
    }
  }

}
