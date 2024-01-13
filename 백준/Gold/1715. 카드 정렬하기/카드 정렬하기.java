import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    if (N == 1) {
      bw.write(0 + "\n");
      bw.flush();
      return;
    }

    PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (int)(a - b));
    long sum = 0;

    for (int i = 0; i < N; i++) {
      pq.add(Long.parseLong(br.readLine()));
    }

    while (true) {
      Long num1 = pq.poll();
      Long num2 = pq.poll();
      Long newNum = num1 + num2;

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
