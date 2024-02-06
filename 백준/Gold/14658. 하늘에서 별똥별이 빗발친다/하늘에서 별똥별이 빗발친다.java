import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N, M, L, K;
  static List<int[]> stars;
  static int boundMax;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    stars = new ArrayList<>();

    for(int i =0 ; i < K ; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      stars.add(new int[]{x, y});
    }

    for (int[] star1 : stars) {
      for (int[] star2 : stars) {
        boundMax = Math.max(boundMax, boundStar(star1[0], star2[1]));
      }
    }

    System.out.println(K - boundMax);
  }

  static int boundStar(int x, int y) {
    int starCount = 0;

    for (int[] star : stars) {
      if (x <= star[0] && star[0] <= x + L && y <= star[1] && star[1] <= y + L) {
        starCount++;
      }
    }
    return starCount;
  }
}
