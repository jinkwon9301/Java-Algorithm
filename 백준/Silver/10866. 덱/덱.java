import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static StringTokenizer st;
  static LinkedList<Integer> dequeue = new LinkedList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      String order = st.nextToken();
      if (order.equals("push_front")) {
        int num = Integer.parseInt(st.nextToken());
        dequeue.addFirst(num);
      } else if (order.equals("push_back")) {
        int num = Integer.parseInt(st.nextToken());
        dequeue.addLast(num);
      } else if (order.equals("pop_front")) {
        if (dequeue.isEmpty()) {
          sb.append(-1 + "\n");
        } else {
          sb.append(dequeue.removeFirst() + "\n");
        }
      } else if (order.equals("pop_back")) {
        if (dequeue.isEmpty()) {
          sb.append(-1 + "\n");
        } else {
          sb.append(dequeue.removeLast() + "\n");
        }
      } else if (order.equals("size")) {
        sb.append(dequeue.size() + "\n");
      } else if (order.equals("empty")) {
        if (dequeue.isEmpty()) {
          sb.append(1 + "\n");
        } else {
          sb.append(0 + "\n");
        }
      } else if (order.equals("front")) {
        if (dequeue.isEmpty()) {
          sb.append(-1 + "\n");
        } else {
          sb.append(dequeue.peek() + "\n");
        }
      } else if (order.equals("back")) {
        if (dequeue.isEmpty()) {
          sb.append(-1 + "\n");
        } else {
          sb.append(dequeue.getLast() + "\n");
        }
      }
    }

    System.out.println(sb.toString());
  }
}