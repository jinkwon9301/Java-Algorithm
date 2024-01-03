import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    str = br.readLine();

    System.out.println(poliomino(str));;
  }

  private static String poliomino(String str) {
    String answer = "";

    answer = str.replaceAll("XXXX", "AAAA");
    answer = answer.replaceAll("XX", "BB");

    if (answer.contains("X")) return "-1";

    return answer;
  }
}
