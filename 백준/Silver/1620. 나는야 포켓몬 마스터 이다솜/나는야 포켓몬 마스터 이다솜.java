import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    Map<String, Integer> map = new HashMap<>();
    String[] arr = new String[N + 1];

    for (int i = 1; i <= N; i++) {
      String pokemon = br.readLine();
      arr[i] = pokemon;
      map.put(pokemon, i);
    }

    for (int i = 0; i < M; i++) {
      String line = br.readLine();
      if (isNumeric(line)) {
        sb.append(arr[Integer.parseInt(line)] + "\n");
      } else {
        sb.append(map.get(line) + "\n");
      }
    }

    System.out.println(sb.toString());
  }

  public static boolean isNumeric(String str) {
    return str != null && str.matches("[0-9]+");
  }
}
