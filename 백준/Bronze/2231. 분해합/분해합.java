import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int sum = 0;

    for (int i = 1; i <= N; i++) {

      int num = i;
      sum += num;
      while (num > 0) {
        sum += num % 10;
        num /= 10;
      }
      if (sum == N) {
        bw.write(i + "\n");
        bw.flush();
        return;
      }

      sum = 0;
    }

    bw.write(0 + "\n");
    bw.flush();
  }
}
