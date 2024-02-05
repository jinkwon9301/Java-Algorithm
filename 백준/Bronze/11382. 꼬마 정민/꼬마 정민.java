import java.io.*;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long sum = 0;
    for (int i = 0; i < 3; i++) {
      long num = Long.parseLong(st.nextToken());
      sum += num;
    }

    System.out.println(sum);
  }
}
