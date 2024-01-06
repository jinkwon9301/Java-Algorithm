import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    Long[] arr = new Long[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }
    Arrays.sort(arr);

    // 근손실 최대값
    long max = 0;

    // N이 짝수일때
    if (N % 2  == 0) {
      for (int i = 0; i < N; i++) {
        max = Math.max(max, arr[i] + arr[(N - 1) - i]);
      }
    }
    // N이 홀수일때
    else {
      max = arr[N - 1];
      for (int i = 0; i < N - 1; i++) {
        max = Math.max(max, arr[i] + arr[(N - 2) - i]);
      }
    }
    System.out.println(max);
  }
}
