// 알고리즘 : BFS
// 출처 : https://jumping-to-the-water.tistory.com/117
import java.util.*;
import java.io.*;

class Main {
  static int N, M, x, y;
  static int[] board;
  static StringTokenizer st;
//  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken()); // 사다리
    M = Integer.parseInt(st.nextToken()); // 뱀

    // (10 X 10) 2차원 배열을 1차원배열로 전환
    board = new int[101];
    for (int i = 0; i < 101; i++) {
      board[i] = i;
    }

    // 사다리, 뱀 배치
    // ex. 사다리 : 12 → 98 의 경우에는 배열 인덱스 2의 값 98
    // ex. 뱀 : 60 → 11 의 경우에는 배열 인덱스 60의 값 11
    for (int i = 0; i < N + M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      board[x] = y;
    }

    System.out.println(bfs());
  }

  private static int bfs() {

    int[] check = new int[101]; // 방문 순서를 기록하기 위한 배열 생성.
    Queue<Integer> q = new LinkedList<>();
    q.offer(1);
    check[0] = 0;

    while (true) {
      int visitedNum = q.poll();
      //주사위 1~6이 나오는 경우를 살피기.
      for (int i = 1; i <= 6; i++) {
        int newNode = visitedNum + i;

        // board의 범위를 넘기면 무시하기
        // check 배열에 IndexOutOfBoundsException을 발생시킬 수 있기 때문
        if (newNode > 100) {
          continue;
        }

        // check되어있는 경우(방문을 한적이 있는 경우)는 무시한다는 것을 전제로 함.
        if (check[board[newNode]] == 0) {
          q.offer(board[newNode]);
          check[board[newNode]] = check[visitedNum] + 1;
        }
        if (board[newNode] == 100) {
          return check[100];
        }
      }
    }
  }
}
