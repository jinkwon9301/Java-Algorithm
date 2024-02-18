import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] arr;
  static boolean[] visited;
  static List<Integer> list = new ArrayList<>();
  static List<Integer> tmpList = new ArrayList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    // 초기화
    arr = new int[N + 1];
    // idx = [0,1,2,3,4,5,6,7]
    // arr = [0,3,1,1,5,5,4,6]
    for (int i = 1; i < N + 1; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    visited = new boolean[N + 1];

    for (int i = 1; i < N + 1; i++) {
      if (!visited[i]) {
        dfs(i, i);
      }
    }

    Collections.sort(list);
    System.out.println(list.size());
    for (Integer integer : list) {
      System.out.println(integer);
    }
  }

  // 사이클을 이루면 두 집합 모두 포함되는 수이다. (ex. 1 -> 3 -> 1)
  private static void dfs(int start, int target) {
    // 순환하는 경우
    if (visited[start] && start == target) {
      for (Integer num : tmpList) {
        list.add(num);
      }
      // tmpList 초기화
      tmpList = new ArrayList<>();
      return;
    }

    // 순환하지 않는 경우 (이미 방문된 곳이라면 -> 사이클을 이루지 않는다.)
    if (visited[start]) {
      // list 초기화, 지금껏 방문한 visited 초기화
      for (Integer num : tmpList) {
        visited[num] = false;
      }
      // tmpList 초기화
      tmpList = new ArrayList<>();
      return;
    }

    visited[start] = true;
    tmpList.add(start);
    dfs(arr[start], target);
  }
}
