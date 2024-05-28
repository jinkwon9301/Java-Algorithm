import java.util.*;
import java.io.*;

class Main {
  static int K, sum;
  static Stack<Integer> stack = new Stack<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    K = Integer.parseInt(br.readLine());
    for (int i = 0; i < K; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num != 0) {
        stack.push(num);
      } else {
        stack.pop();
      }
    }

    while (!stack.isEmpty()) {
      sum += stack.pop();
    }

    System.out.println(sum);
  }
}

