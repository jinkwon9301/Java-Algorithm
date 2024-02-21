import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int T, N;
  static StringTokenizer st;
  static int[] arr;
  static boolean[] visited, done;
  static int count;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    T = Integer.parseInt(br.readLine());

    // 테스트케이스 만큼 시행한다.
    for (int i = 0; i < T; i++) {

      // 초기화
      N = Integer.parseInt(br.readLine());
      arr = new int[N + 1];
      visited = new boolean[N + 1];
      done = new boolean[N + 1];
      count = 0;

      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j < N + 1; j++) {
        arr[j] = Integer.parseInt(st.nextToken());
      }
      // ->
      // idx = [0,1,2,3,4,5,6,7]
      // stu = [0,3,1,3,7,3,4,6]

      for (int j = 1; j < N + 1; j++) {
        if (!visited[j]) {
          dfs(j);
        }
      }

      // 팀을 이루지 못한 학생수 출력
      System.out.println(N - count);
    }

  }

  private static void dfs(int now) {
    // 현재 학생을 방문처리한다.
    visited[now] = true;
    int next = arr[now];

    // 그 학생이 선택한 다음 학생이 미방문 상태라면 방문한다.
    if (!visited[next]) {
      dfs(next);
    } else {
      // 만약 다음 학생을 이미 방문했고 && 그 학생이 cycle 형성에 사용되지 않은 학생이라면
      // 이제 사이클이 형성된 것이다. 사이클을 이루는 학생 수를 센다.
      if (!done[next]) {
        count++;
        while (next != now) {
          count++;
          next = arr[next];
        }
      }
    }

    // cycle 형성에 관여한 학생들을 done 처리한다.
    done[now] = true;
  }
}
