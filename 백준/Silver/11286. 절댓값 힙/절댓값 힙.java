// 알고리즘 : 우선순위 큐 (Priority Queue)
import java.util.*;
import java.io.*;

class Main {
  static int N;
  //   static StringTokenizer st;
  static PriorityQueue pq;
   static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    Comparator<Integer> comparator = (a, b) -> {
      int absA = Math.abs(a);
      int absB = Math.abs(b);

      // 절대값을 기준으로 비교
      if (absA != absB) {
        return Integer.compare(absA, absB);
      } else {
        // 절대값이 같다면 음수를 우선
        return Integer.compare(a, b);
      }
    };

    pq = new PriorityQueue<Integer>(comparator);

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num == 0) {
        if (pq.isEmpty()) {
          sb.append(0 + "\n");
        } else {
          sb.append(pq.poll() + "\n");
        }
      } else {
        pq.add(num);
      }
    }

    System.out.println(sb.toString());
  }
}
