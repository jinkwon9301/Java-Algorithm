import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int N, M, P;
  static int[] channel;
  // 1 → 2 → 3 → 1 → 2 → 3 이렇게 순환안하고
  // 1 → 2 → 3 → 2 → 3 이렇게 순환할 수도 있기 때문에
  // visited 배열로 순환하는지 검증해야 한다.
  static boolean[] visited;
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());

    // 그래프 초기화 (채널들을 정점으로 그래프 만든다.)
    channel = new int[M + 1];
    visited = new boolean[M + 1];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int favorite = Integer.parseInt(st.nextToken());
      int hate = Integer.parseInt(st.nextToken());

      // 싫어하는 채널에서 좋아하는 채널로 바꿀 수 있도록 그래프를 완성해준다.
      // (channel index : 싫어하는 채널 → value : 좋아하는 채널)
      // 만약 특정 채널을 싫어하는 사람들이 많다면 가장 어린 애가 좋아하는 채널이 입력되도록
      if (channel[hate] == 0) {
        channel[hate] = favorite;
      }
    }

    dfs(P, 0);
  }

  private static void dfs(int now, int count) {
    // 종료조건
    // 지금 이 채널을 싫어하는 사람이 없다면 채널변경 횟수(count) 보여주고 중단한다.
    if(channel[now] == 0) {
      System.out.println(count);
      return;
    }

    // 무한순환하는 경우에는 -1 보여주고 중단한다.
    if (visited[now]) {
      System.out.println(-1);
      return;
    }
    visited[now] = true;
    dfs(channel[now], count + 1);
  }
}