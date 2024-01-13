import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    String nums = br.readLine();

    Stack<Character> stack = new Stack<>();
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < N; ) {
      char num = nums.charAt(i);
        
      if (K == 0) {
        stack.push(num);
        i++;
        continue;
      }
      
      if (stack.isEmpty()) {
        stack.push(num);
        i++;
      } else {
        if (stack.peek() >= num) {
          stack.push(num);
          i++;
        } else {
          stack.pop();
          K--;
        }
      }
    }
    
    while (K > 0) {
      stack.pop();
      K--;
    }
    
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
    }
    
    bw.write(sb.toString() + "\n");
    bw.flush();
  }
}
