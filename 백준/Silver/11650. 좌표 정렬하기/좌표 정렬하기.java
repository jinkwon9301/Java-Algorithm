import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static StringTokenizer st;
  static Location[] locations;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    locations = new Location[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      locations[i] = new Location(x, y);
    }

    Arrays.sort(locations, (a,b) -> a.y - b.y);
    Arrays.sort(locations, (a,b) -> a.x - b.x);

    for (Location location : locations) {
      System.out.println(location.x + " " + location.y);
    }
  }

  static class Location {
    int x;
    int y;

    public Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}