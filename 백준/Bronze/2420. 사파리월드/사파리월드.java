import java.io.*;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    long num1 = Long.parseLong(st.nextToken());
    long num2 = Long.parseLong(st.nextToken());
    long sum = Math.abs(num1 - num2);
    
    System.out.println(sum);
  }
}
