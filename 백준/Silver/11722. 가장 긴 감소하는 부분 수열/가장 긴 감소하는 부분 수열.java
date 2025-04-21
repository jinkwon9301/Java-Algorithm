import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int N, max;
  static int[] arr, dp;
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    dp = new int[N];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      dp[i] = 1;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] < arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    for (int i : dp) {
      max = Math.max(max, i);
    }
    
    System.out.println(max);
  }
}

