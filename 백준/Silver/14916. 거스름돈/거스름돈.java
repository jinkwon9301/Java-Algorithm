import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static int count = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    str = br.readLine();
    int num = Integer.parseInt(str);

    System.out.println(solution(num));
  }

  private static int solution(int num) {
    if (num == 1 || num == 3) return -1;

    while (num >= 9 || num == 5 || num == 7) {
      num -= 5;
      count++;
    }

    while (num > 0) {
      num -= 2;
      count++;
    }

    return count;
  }
}