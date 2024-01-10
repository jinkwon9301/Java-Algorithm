import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    // int[][] 배열에 넣는다.
    int[][] times = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      times[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
    }

    // int[][] 배열을 시작 시간 순서로 오름차순 정렬한다.
    Arrays.sort(times, (a,b) -> a[0] - b[0]);

    // PriorityQueue를 만든다. (PriorityQueue : 종료시간 오름차순 정렬)
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    // 큐에 element가 없으면 추가한다. 만약 픽했을 때 (큐의 요소의 종료시간 <= 배열의 시작시간) 이면 queue.poll()하고 새로운 요소를 추가한다.
    for (int i = 0; i < N; i++) {
      if (!pq.isEmpty() && pq.peek()[1] <= times[i][0]) {
        pq.poll();
      }
      pq.add(times[i]);
    }

    // queue.size() 를 return
    bw.write(pq.size() + "\n");
    bw.flush();
  }
}
