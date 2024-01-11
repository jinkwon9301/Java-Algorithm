import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    ArrayList<Integer> cranes = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      cranes.add(Integer.parseInt(st.nextToken()));
    }

    int M = Integer.parseInt(br.readLine());
    ArrayList<Integer> boxes = new ArrayList<>();
    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < M; i++) {
      boxes.add(Integer.parseInt(st2.nextToken()));
    }

    Collections.sort(cranes, Collections.reverseOrder());
    Collections.sort(boxes, Collections.reverseOrder());

    if (cranes.get(0) < boxes.get(0)) {
      bw.write(-1 + "\n");
      bw.flush();
      return;
    }

    int times = 0;

    while (!boxes.isEmpty()) {
      times++;
      int idx = 0;
      for (int i = 0; i < N; ) {
        if (boxes.size() == idx) break;
        if (cranes.get(i) >= boxes.get(idx)) {
          boxes.remove(idx);
          i++;
        } else {
          idx++;
        }
      }
    }

    bw.write(times + "\n");
    bw.flush();
  }
}
