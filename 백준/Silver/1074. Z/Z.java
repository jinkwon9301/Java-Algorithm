import java.util.*;
import java.io.*;

class Main {
  static int N, r, c, answer;
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    dfs((int)Math.pow(2, N), r, c);
    System.out.println(answer);
  }

  private static void dfs(int N, int r, int c) {
    // 만약 N이 1이라면 중단한다.
    if (N == 1) return;

    // 1,2,3,4 사분면중에서 어디에 해당하는지 판단한다.
    // 1 사분면
    if (r < N / 2 && c < N / 2) {
      answer += 0;
      dfs(N / 2, r, c);
    }
    // 2 사분면
    if (r < N / 2 && c >= N / 2) {
      answer += Math.pow(N / 2, 2);
      dfs(N / 2, r, c - N / 2);
    }
    // 3 사분면
    if (r >= N / 2 && c < N / 2) {
      answer += Math.pow(N / 2, 2) * 2;
      dfs(N / 2, r - N / 2, c);
    }
    // 4 사분면
    if (r >= N / 2 && c >= N / 2) {
      answer += Math.pow(N / 2, 2) * 3;
      dfs(N / 2, r - N / 2, c - N / 2);
    }
  }
}
