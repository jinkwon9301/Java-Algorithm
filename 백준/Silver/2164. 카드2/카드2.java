import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int N;
  static Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    for (int i = 1; i <= N; i++) {
      queue.offer(i);
    }

    while (queue.size() > 1) {
      queue.poll();
      queue.offer(queue.poll());
    }

    System.out.println(queue.poll());
  }
}
