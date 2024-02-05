import java.io.*;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long sum = 0;
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < 5; i++) {
      int num = Integer.parseInt(st.nextToken());
      sum += Math.pow(num, 2);
    }

    System.out.println((int) sum % 10);
  }
}
