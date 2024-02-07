import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int[] paper = {0, 5, 5, 5, 5, 5};
  static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    map = new int[10][10];
    for (int i = 0; i < map.length; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < map[i].length; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

//    map = new int[][] {
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
//        {0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
//        {0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
//        {0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
//        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//        {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
//        {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
//        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
//        {0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
//    };

    DFS(0, 0, 0);

    if (min == Integer.MAX_VALUE) {
      min = -1;
    }

    bw.write(min + "\n");
    bw.close();
    br.close();
  }

  public static void DFS(int x, int y, int cnt) {

    // 종료 조건 (끝에 map 끝에 다다르면 종료한다.)
    if (x == 9 && y == 10) {
      min = Math.min(Main.min, cnt);
      return;
    }

    // 만약 cnt가 min보다 크거나 같아도 종료 (더하는건 의미가 없기 때문)
    if (min <= cnt) {
      return;
    }

    // 오른쪽 끝까지 갔다면 아래로 한칸 이동한다.
    if (y == 10) {
      DFS(x + 1, 0, cnt);
      // 한칸 내려줄 때는 return 해줘야지 아니면 끝까지 탐색한 후에 y == 10인 상태로 계속 진행되서 map[][10]되서 ArrayIndexOutOfBound 에러 터짐
      return;
    }

    if (map[x][y] == 1) {
      for (int i = 1; i <= 5; i++) {
        // 색종이가 남아있으며 && 색종이를 붙일 수 있으면 (map범위를 벗어나지 않으면)
        if (paper[i] > 0 && isAttach(x, y, i)) {
          // 색종이를 붙인다.
          attach(x, y, i, 0);
          paper[i]--;
          // 오른쪽으로 한칸 이동해서 다음을 탐색한다.
          DFS(x, y + 1, cnt + 1);
          // 탐색을 마치면 색종이를 뗀다.
          attach(x, y, i, 1);
          paper[i]++;
        }
      }
    }
    // map[x][y] == 0 이라면 오른쪽으로 한칸 이동해서 탐색
    else {
      DFS(x, y + 1, cnt);
    }
  }

  private static void attach(int x, int y, int length, int state) {
    for (int i = x; i < x + length; i++) {
      for (int j = y; j < y + length; j++) {
        map[i][j] = state;
      }
    }
  }

  private static boolean isAttach(int x, int y, int length) {
    for (int i = x; i < x + length; i++) {
      for (int j = y; j < y + length; j++) {
        if (i >= 10 || j >= 10 || map[i][j] == 0) return false;
      }
    }
    return true;
  }
}

