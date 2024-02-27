import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static StringTokenizer st;
  static Map<Integer, Integer> map = new HashMap<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < M; i++) {
      int num = Integer.parseInt(st.nextToken());
      sb.append(map.getOrDefault(num, 0) + " ");
    }

    System.out.println(sb.toString().substring(0, sb.toString().length() - 1));
  }
}

