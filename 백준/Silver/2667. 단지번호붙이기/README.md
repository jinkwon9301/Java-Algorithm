# [Silver I] 단지번호붙이기 - 2667 

[문제 링크](https://www.acmicpc.net/problem/2667) 

### 성능 요약

메모리: 14148 KB, 시간: 104 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2025년 4월 1일 23:47:02

### 문제 설명

<p><그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.</p>

<p style="text-align: center;"><img alt="" src="https://www.acmicpc.net/upload/images/ITVH9w1Gf6eCRdThfkegBUSOKd.png" style="height:192px; width:409px"></p>

### 입력 

 <p>첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.</p>

### 출력 

 <p>첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.</p>

```java
import java.util.*;
import java.io.*;

class Main {
  static int N;
  static int[][] field;
  static boolean[][] visited;
  static PriorityQueue<Integer> pq = new PriorityQueue<>();
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    field = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        field[i][j] = line.charAt(j) - '0';
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (field[i][j] == 1 && !visited[i][j]) {
          bfs(new int[] {i, j});
        }
      }
    }

    sb.append(pq.size()).append("\n");
    while (!pq.isEmpty()) {
      sb.append(pq.poll()).append("\n");
    }
    System.out.print(sb.toString());
  }

  private static void bfs(int[] start) {
    LinkedList<int[]> queue = new LinkedList<>();
    queue.add(start);
    visited[start[0]][start[1]] = true;
    int count = 0;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];

      count++;

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (checkValid(nx, ny) && field[nx][ny] == 1 && !visited[nx][ny]) {
          queue.add(new int[] {nx, ny});
          visited[nx][ny] = true;
        }
      }
    }

    pq.add(count);
  }

  // 범위를 벗어나지 않는지 확인하는 메서드
  private static boolean checkValid(int x, int y) {
    if (x < 0 || x >= N || y < 0 || y >= N) {
      return false;
    }
    return true;
  }
}
```

* 주의할 점 : 
- BFS 할 때 visited[nx][ny] = true; 해주는 시기가 중요하다. 큐에 넣으면서 visited[nx][ny] = true; 해줘야한다. 만약 꺼내서 visited[nx][ny] = true; 해주려 하면 큐에 같은 좌표가 중복으로 들어갈 수 있다.
- PriorityQueue 는 for-each로 꺼내면 순서가 보장되지 않는다. PriorityQueue는 내부적으로 Heap(힙) 자료구조를 사용한다. 이 힙은 전체 요소들을 오름차순으로 정렬해두는 게 아니라, 가장 작은 값(루트 노드)만 빠르게 꺼낼 수 있게 구성돼 있다.
