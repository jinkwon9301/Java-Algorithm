import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static StringTokenizer st;
  static Stack<Integer> stack = new Stack<>();
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
        stack.push(num);
      } else if (order.equals("pop")) {
        if (stack.isEmpty()) {
          sb.append(-1 + "\n");
        } else {
          sb.append(stack.pop() + "\n");
        }
      } else if (order.equals("size")) {
        sb.append(stack.size() + "\n");
      } else if (order.equals("empty")) {
        if (stack.isEmpty()) {
          sb.append(1 + "\n");
        } else {
          sb.append(0 + "\n");
        }
      } else if (order.equals("top")) {
        if (stack.isEmpty()) {
          sb.append(-1 + "\n");
        } else {
          sb.append(stack.peek() + "\n");
        }
      }
    }

    System.out.println(sb.toString());
  }
}
