import java.util.*;
import java.io.*;

class Main {
  static int idx, num, nextNum;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (idx++ < 3) {
      String line = br.readLine();
      if (isNumeric(line)) {
        num = Integer.parseInt(line);
        break;
      }
    }

    nextNum = num + 4 - idx;

    if (isMultiple3(nextNum) && isMultiple5(nextNum)) {
      System.out.println("FizzBuzz");
      return;
    } else if (isMultiple3(nextNum)) {
      System.out.println("Fizz");
      return;
    } else if (isMultiple5(nextNum)) {
      System.out.println("Buzz");
      return;
    } else {
      System.out.println(nextNum);
      return;
    }
  }

  public static boolean isNumeric(String str) {
    return str != null && str.matches("[0-9]+");
  }

  public static boolean isMultiple3(int num) {
    return num % 3 == 0;
  }

  public static boolean isMultiple5(int num) {
    return num % 5 == 0;
  }
}

