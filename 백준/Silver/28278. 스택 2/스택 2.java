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

      int order = Integer.parseInt(st.nextToken());
      switch (order) {
        case 1:
          int num = Integer.parseInt(st.nextToken());
          stack.push(num);
          break;
        case 2:
          if (!stack.isEmpty()) {
            sb.append(stack.pop() + "\n");
          } else {
            sb.append(-1 + "\n");
          }
          break;
        case 3:
          sb.append(stack.size() + "\n");
          break;
        case 4:
          if (stack.isEmpty()) {
            sb.append(1 + "\n");
          } else {
            sb.append(0 + "\n");
          }
          break;
        case 5:
          if (!stack.isEmpty()) {
            sb.append(stack.peek() + "\n");
          } else {
            sb.append(-1 + "\n");
          }
          break;
      }
    }

    System.out.println(sb.toString());
  }
}
