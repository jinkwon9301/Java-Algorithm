// 알고리즘 : 우선순위 큐 (Priority Queue)
import java.util.*;
import java.io.*;

class Main {
  static int N;
  static PriorityQueue pq;
//   static StringTokenizer st;
   static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    Comparator<Integer> comparator = (a, b) -> b - a;
    pq = new PriorityQueue<Integer>(comparator);

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num != 0) {
        pq.offer(num);
      } else {
        if (pq.isEmpty()) {
          sb.append(0 + "\n");
        } else {
          sb.append(pq.poll() + "\n");
        }
      }
    }

    System.out.println(sb.toString());
  }
}
