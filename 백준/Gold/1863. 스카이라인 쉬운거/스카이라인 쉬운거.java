import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    Stack<Integer> stack = new Stack<>();
    int count = 0;
    boolean isDone = false;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      st.nextToken();
      int height = Integer.parseInt(st.nextToken());

      isDone = false;
      while (!isDone) {
        // 만약 스택이 비었다면 스택을 쌓는다.
        if (stack.isEmpty()) {
          if (height != 0) stack.push(height);
          isDone = true;
        }

        // 스택이 비어있지 않으면
        else {
          // 스택.peek()보다 크면 스택을 쌓고
          if (stack.peek() < height) {
            stack.push(height);
            isDone = true;
          }

          // 스택.peek()과 같으면 아무것도 하지 않는다
          else if (stack.peek() == height) {
            isDone = true;
          }

          // 스택.peek()보다 작으면 스택을 빼고 count++
          else if (stack.peek() > height) {
            stack.pop();
            count++;
          }
        }
      }
    }

    while (!stack.isEmpty()) {
      stack.pop();
      count++;
    }

    bw.write(count + "\n");
    bw.flush();
  }
}
