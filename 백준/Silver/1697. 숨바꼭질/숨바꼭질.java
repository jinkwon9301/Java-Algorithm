import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  static int N, K;
  static int min = 100000;
  static boolean[] visited = new boolean[100001];
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    bfs(N);

    System.out.println(min);
  }

  private static void bfs(int n) {
    visited[n] = true;

    LinkedList<Integer[]> queue = new LinkedList<>();
    queue.add(new Integer[]{n, 0});

    while (!queue.isEmpty()) {
      Integer[] info = queue.poll();
      Integer num = info[0];
      Integer count = info[1];

      if (num == K) {
        min = Math.min(min, count);
      }

      if (num - 1 >= 0 && !visited[num - 1]) {
        queue.add(new Integer[]{num - 1, count + 1});
        visited[num - 1] = true;
      }
      if (num + 1 <= 100000 && !visited[num + 1]) {
        queue.add(new Integer[]{num + 1, count + 1});
        visited[num + 1] = true;
      }
      if (num * 2 <= 100000 && !visited[num * 2]) {
        queue.add(new Integer[]{num * 2, count + 1});
        visited[num * 2] = true;
      }
    }
  }
}