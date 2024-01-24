import java.io.*;
import java.util.*;

public class Main {

  static int K;
  static char[] arr;
  static boolean[] visited;
  static ArrayList<String> list = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    K = Integer.parseInt(br.readLine()) + 1;
    arr = new char[K - 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K - 1; i++) {
      arr[i] = st.nextToken().charAt(0);
    }

    for (int i = 0; i < 10; i++) {
      visited = new boolean[10];
      visited[i] = true;
      dfs(i,0, i + "");
      visited[i] = false;
    }

    System.out.println(list.get(list.size()-1));
    System.out.println(list.get(0));
  }

  static void dfs(int num, int cnt, String word) {

    if (word.length() == K) { // 부등호의 모든 조건을 달성하면 종료
      list.add(word);
      return;
    }

    for (int i = 0; i < 10; i++) {
      if(!visited[i]) {
        char tmp = arr[cnt];
        if (tmp == '>') {
          if (num > i) {
            visited[i] = true;
            dfs(i, cnt + 1, word + i);
            visited[i] = false;
          }
        } else {
          if (num < i) {
            visited[i] = true;
            dfs(i, cnt + 1, word + i);
            visited[i] = false;
          }
        }
      }
    }
  }
}
