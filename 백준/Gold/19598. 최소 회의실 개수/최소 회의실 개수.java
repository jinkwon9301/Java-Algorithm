import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    // 회의시간을 담을 배열을 만든다.
    int[][] times = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      times[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }

    // 배열을 회의시작 시간 기준으로 오름차순 정렬한다.
    Arrays.sort(times, (a, b) -> a[0] - b[0]);

    // PriorityQueue 를 만들고 정렬기준을 회의 종료 시간으로 한다.
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    // PriorityQueue 가 비어있으면 요소를 넣고, 비어있지 않으면서 (peek()한 요소의 종료시간 <= 배열요소의 시작시간) 이면 queue.poll() 하고 배열 요소를 add 한다.
    for (int i = 0; i < N; i++) {
      if (!pq.isEmpty() && pq.peek()[1] <= times[i][0]) {
        pq.poll();
      }
      pq.add(times[i]);
    }

    // PrioriryQueue size를 출력
    bw.write(pq.size() + "\n");
    bw.flush();
  }
}
