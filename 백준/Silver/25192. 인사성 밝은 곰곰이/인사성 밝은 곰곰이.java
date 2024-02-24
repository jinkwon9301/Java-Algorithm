import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
  static int N, count;
  static Map<String, Boolean> map = new HashMap<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String line = br.readLine();

      if (line.equals("ENTER")) {
        map = new HashMap<>();
      } else {
        if (map.get(line) == null) {
          map.put(line, true);
          count++;
        }
      }
    }

    System.out.println(count);
  }
}

