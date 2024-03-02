import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static StringTokenizer st;
  static LinkedList<Integer> queue = new LinkedList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      String order = st.nextToken();
      if (order.equals("push")) {
        int num = Integer.parseInt(st.nextToken());
        queue.add(num);
      } else if (order.equals("pop")) {
        if (queue.isEmpty()) {
          sb.append(-1 + "\n");
        } else {
          sb.append(queue.poll() + "\n");
        }
      } else if (order.equals("size")) {
        sb.append(queue.size() + "\n");
      } else if (order.equals("empty")) {
        if (queue.isEmpty()) {
          sb.append(1 + "\n");
        } else {
          sb.append(0 + "\n");
        }
      } else if (order.equals("front")) {
        if (queue.isEmpty()) {
          sb.append(-1 + "\n");
        } else {
          sb.append(queue.peek() + "\n");
        }
      } else if (order.equals("back")) {
        if (queue.isEmpty()) {
          sb.append(-1 + "\n");
        } else {
          sb.append(queue.getLast() + "\n");
        }
      }
    }

    System.out.println(sb.toString());
  }
}
