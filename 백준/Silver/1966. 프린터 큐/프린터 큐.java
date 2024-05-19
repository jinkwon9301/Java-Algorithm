import java.util.*;
import java.io.*;

class Main {
  static int testCaseNum, N, M, count;
  static LinkedList<int[]> queue;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();
  static boolean isMax;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    testCaseNum = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCaseNum; i++) {
      // LinkedList는 get() 사용가능, Queue는 get() 사용 불가능
      queue = new LinkedList<>();

      st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken()); // 전체 문서 수
      M = Integer.parseInt(st.nextToken()); // 문서 번호

      st = new StringTokenizer(br.readLine(), " ");

      for (int j = 0; j < N; j++) {
        queue.offer(new int[]{j, Integer.parseInt(st.nextToken())});
      }

      count = 0;

      while (!queue.isEmpty()) {
        int[] front = queue.poll();
        isMax = true;

        // 만약 큐에서 꺼낸 문서의 중요도 > 첫번째 문서의 중요도
        for (int j = 0; j < queue.size(); j++) {
          if (front[1] < queue.get(j)[1]) {
            isMax = false;

            queue.offer(front);
            for (int k = 0; k < j; k++) {
              queue.offer(queue.poll());
            }

            break;
          }
        }

        if (isMax) {
          count++;

          if (front[0] == M) {
            sb.append(count + "\n");
            break;
          }
        }
      }
    }

    System.out.println(sb.toString());
  }
}

