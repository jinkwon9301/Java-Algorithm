# [Silver II] DFS와 BFS - 1260 

[문제 링크](https://www.acmicpc.net/problem/1260) 

### 성능 요약

메모리: 20652 KB, 시간: 256 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2024년 2월 26일 22:50:14

### 문제 설명

<p>그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.</p>

### 입력 

 <p>첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.</p>

### 출력 

 <p>첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.</p>

---

Graph 자료구조

```java
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* 인접 리스트를 이용한 방향성 있는 그래프 클래스 */
class Graph {
  private int V; // 노드의 개수
  private LinkedList<Integer> adj[]; // 인접 리스트

  /** 생성자 */
  Graph(int v) {
    V = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i) // 인접 리스트 초기화
      adj[i] = new LinkedList();
  }

  /** 노드를 연결 v->w */
  void addEdge(int v, int w) { adj[v].add(w); }

  /** s를 시작 노드으로 한 BFS로 탐색하면서 탐색한 노드들을 출력 */
  void BFS(int s) {
    // 노드의 방문 여부 판단 (초깃값: false)
    boolean visited[] = new boolean[V];
    // BFS 구현을 위한 큐(Queue) 생성
    LinkedList<Integer> queue = new LinkedList<Integer>();

    // 현재 노드를 방문한 것으로 표시하고 큐에 삽입(enqueue)
    visited[s] = true;
    queue.add(s);

    // 큐(Queue)가 빌 때까지 반복
    while (queue.size() != 0) {
      // 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
      s = queue.poll();
      System.out.print(s + " ");

      // 방문한 노드와 인접한 모든 노드를 가져온다.
      Iterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        // 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }

  /** s를 시작 노드으로 한 DFS로 탐색하면서 탐색한 노드들을 출력 */
  void DFS(int s, boolean[] visited) {
    // 현재 노드를 방문한 것으로 표시
    visited[s] = true;
    System.out.print(s + " ");

    // 방문한 노드와 인접한 모든 노드를 가져온다.
    ListIterator<Integer> i = adj[s].listIterator();
    while (i.hasNext()) {
      Integer n = i.next();
      // 방문하지 않은 노드면 DFS 탐색한다
      if (!visited[n]) {
        DFS(n, visited);
      }
    }
  }
}

```

Graph 자료구조를 응용한 풀이 (sortEdge 추가)

```java
import java.io.*;
import java.util.*;

public class Main {
  static int N, M, V;
  static StringTokenizer st;
  static StringBuilder dfs = new StringBuilder();
  static StringBuilder bfs = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    // 그래프를 생성한다.
    Graph graph = new Graph(N + 1);

    // 간선을 이어준다.
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph.addEdge(v, w);
      graph.addEdge(w, v);
    }

    // 간선의 순서를 정렬한다.(?)
    graph.sortEdge();

    // DFS, BFS 탐색한다.
    graph.DFS(V, new boolean[graph.V]);
    graph.BFS(V);
    System.out.println(dfs.toString().substring(0, dfs.toString().length() - 1));
    System.out.println(bfs.toString().substring(0, bfs.toString().length() - 1));
  }

  static class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
      V = v;
      adj = new LinkedList[v];
      for (int i = 0; i < v; ++i)
        adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) { adj[v].add(w); }

    void sortEdge() {
      for (int i = 0; i < V; i++) {
        Collections.sort(adj[i]);
      }
    }

    void BFS(int s) {
      boolean visited[] = new boolean[V];
      LinkedList<Integer> queue = new LinkedList<Integer>();

      visited[s] = true;
      queue.add(s);

      while (queue.size() != 0) {
        s = queue.poll();
        bfs.append(s + " ");

        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()) {
          int n = i.next();
          if (!visited[n]) {
            visited[n] = true;
            queue.add(n);
          }
        }
      }
    }

    void DFS(int s, boolean[] visited) {
      visited[s] = true;
      dfs.append(s + " ");

      ListIterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        Integer n = i.next();
        if (!visited[n]) {
          DFS(n, visited);
        }
      }
    }
  }
}

```
