import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static HashMap<String, String> map = new HashMap<>();
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      map.put(st.nextToken(), st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      String site = br.readLine();
      sb.append(map.get(site) + "\n");
    }

    System.out.println(sb.toString());
  }
}
