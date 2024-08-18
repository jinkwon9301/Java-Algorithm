import java.util.*;
import java.io.*;

class Main {
  static int T, N, maxCase;
  static HashMap<String, Integer> map = new HashMap<>();
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      maxCase = 1;
      N = Integer.parseInt(br.readLine());
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine(), " ");
        String name = st.nextToken();
        String type = st.nextToken();
        map.put(type, map.getOrDefault(type, 0) + 1);
      }
      for (Integer value : map.values()) {
        maxCase *= (value + 1);
      }
      maxCase -= 1;
      sb.append(maxCase + "\n");
      map = new HashMap<>();
    }
    System.out.println(sb.toString());
  }
}
