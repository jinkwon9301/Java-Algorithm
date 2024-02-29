import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  static int N, K, count;
  static StringTokenizer st;
  static LinkedList<Integer> queue = new LinkedList<>();
  static StringBuffer sb = new StringBuffer();
  static String answer = "";

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    for (int i = 1; i < N + 1; i++) {
      queue.offer(i);
    }

    sb.append("<");

    while (!queue.isEmpty()) {
      count++;
      Integer num = queue.poll();
      if (count % K == 0) {
        sb.append(num + ", ");
      } else {
        queue.offer(num);
      }
    }

    answer = sb.toString();
    answer = answer.substring(0, answer.length() - 2);
    answer += ">";
    System.out.println(answer);
  }
}

