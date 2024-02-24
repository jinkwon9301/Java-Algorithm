import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static Map<String, Boolean> map = new HashMap<>();
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    map.put("ChongChong", true);

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      String person1 = st.nextToken();
      String person2 = st.nextToken();

      if (map.get(person1) != null || map.get(person2) != null) {
        map.put(person1, true);
        map.put(person2, true);
      }
    }

    System.out.println(map.size());
  }
}

