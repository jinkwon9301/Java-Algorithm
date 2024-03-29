import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int size;
  static Queue<Integer> queue = new LinkedList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    size = Integer.parseInt(br.readLine());

    while (true) {
      int info = Integer.parseInt(br.readLine());
      if (info == -1) break;

      if (info == 0) {
        queue.poll();
        continue;
      }

      if (queue.size() == size) continue;

      queue.offer(info);
    }

    if (queue.isEmpty()) {
      System.out.println("empty");
      return;
    }

    while (!queue.isEmpty()) {
      sb.append(queue.poll() + " ");
    }

    String answer = sb.toString();

    System.out.println(answer.substring(0, answer.length() - 1));
  }
}

