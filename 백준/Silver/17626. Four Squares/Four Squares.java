// 사용된 알고리즘 → DP, 참고 → https://steady-coding.tistory.com/18
import java.util.*;
import java.io.*;

class Main {
  static int N, min;
  static int[] dp;
  // static StringTokenizer st;
  // static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    /*
       1 →  1²                    1개
       2 →  1² + 1²               2개
       3 →  1² + 1² + 1²          3개
       4 →  2²                    1개
       5 →  2² + 1²               2개
       6 →  2² + 1² + 1²          3개
       7 →  2² + 1² + 1² + 1²     4개
       8 →  2² + 2²               2개
       9 →  3²                    1개
      10 →  3² + 1²               2개
      11 →  3² + 1² + 1²          3개
      12 →  3² + 1² + 1² + 1²     4개
      13 →  3² + 2²               2개
      14 →  3² + 2² + 1²          3개
      15 →  3² + 2² + 1² + 1²     4개
      16 →  4²                    1개
    */

    // dp[i] = min(dp[i - j²] + 1)임을 알 수 있다.
    // dp[i - j²] 중 가장 작은 것을 찾고 +1 해준다. (+1은 제곱수 하나의 경우 1개이기 때문)

    dp = new int[N + 1];
    dp[1] = 1;

    for (int i = 2; i < N + 1; i++) {
      min = 5;
      for (int j = 1; j*j <= i; j++) {
        min = Math.min(min, dp[i - j * j] + 1);
      }
      dp[i] = min;
    }

    System.out.println(dp[N]);
  }
}
