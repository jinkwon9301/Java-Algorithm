// 알고리즘 : DP, 참고 : https://girawhale.tistory.com/34
// dp[n] = dp[n−1] + 2 × dp[n−2]
import java.util.*;
import java.io.*;

class Main {
  static int N;
  static int[] dp;
//  static StringTokenizer st;
//  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    dp = new int[1001];
    dp[1] = 1;
    dp[2] = 3;
    for (int i = 3; i <= N; i++) {
      dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
    }
    System.out.println(dp[N]);
  }
}
