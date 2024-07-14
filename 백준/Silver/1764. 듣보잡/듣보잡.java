import java.util.*;
import java.io.*;

class Main {
  static int N, M, count;
  static Map<String, Boolean> map = new HashMap<>();
  static List<String> list = new ArrayList<>();
  static StringTokenizer st;
  static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      String unheardPerson = br.readLine();
      map.put(unheardPerson, true);
    }

    for (int i = 0; i < M; i++) {
      String unseenPerson = br.readLine();
      if (map.get(unseenPerson) != null) {
        count++;
        list.add(unseenPerson);
      }
    }

    Collections.sort(list);
    for (String s : list) {
      sb.append(s + "\n");
    }

    System.out.println(count);
    System.out.println(sb.toString());
  }
}
