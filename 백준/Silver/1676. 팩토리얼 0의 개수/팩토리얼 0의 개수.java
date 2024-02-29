import java.io.*;

public class Main {
  static int N, num, five;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    for (int i = 1; i <= N; i++) {
      num = i;

      while (num % 5 == 0) {
        num /= 5;
        five++;
      }
    }

    System.out.println(five);
  }
}

