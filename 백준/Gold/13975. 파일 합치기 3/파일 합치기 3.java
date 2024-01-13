import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      int K = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (int)(a - b));
      for (int j = 0; j < K; j++) {
        pq.add(Long.parseLong(st.nextToken()));
      }

      long sum = 0;

      while (true) {
        Long num1 = pq.poll();
        Long num2 = pq.poll();
        long newNum = num1 + num2;

        sum += newNum;

        if (pq.isEmpty()) {
          bw.write(sum + "\n");
          bw.flush();
          break;
        }

        pq.add(newNum);
      }
    }
  }
}
