import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int num = 666;
    int count = 1;

    while (count != N) {
      num++;
      if (String.valueOf(num).contains("666")) {
        count++;
      }
    }

    bw.write(num + "\n");
    bw.flush();
  }
}
