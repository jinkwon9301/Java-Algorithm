import java.io.*;
import java.util.Stack;

public class Main {
  static int T;
  static Stack<Character> stack;
  static boolean isVPS;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String line = br.readLine();
      stack = new Stack<>();
      isVPS = true;

      for (int j = 0; j < line.length(); j++) {
        if (line.charAt(j) == '(') {
          stack.push('(');
        } else {
          if (!stack.isEmpty()) {
            stack.pop();
          } else {
            isVPS = false;
            break;
          }
        }
      }

      if (stack.isEmpty() && isVPS) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}

