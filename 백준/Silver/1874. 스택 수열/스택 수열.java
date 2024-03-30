import java.util.*;
import java.io.*;

class Main {
  static int N, num, idx;
  static int[] arr;
  static Stack<Integer> stack = new Stack<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    num = 1;

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 0; i < N * 2; i++) {
      // push (+) 하거나
      // pop (-) 하거나 둘중 하나
      // 1 ~ N 까지 순서대로 한다. num = 1;
      if (stack.isEmpty() || stack.peek() < arr[idx]) {
        stack.push(num++);
        sb.append("+" + "\n");
      } else if (stack.peek() == arr[idx]) {
        stack.pop();
        sb.append("-" + "\n");
        idx++;
      } else if (stack.peek() > arr[idx]) {
        System.out.println("NO");
        System.exit(0);
      }
    }

    System.out.println(sb.toString());
  }
}

