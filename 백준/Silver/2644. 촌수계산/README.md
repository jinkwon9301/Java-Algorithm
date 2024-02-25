# [Silver II] 촌수계산 - 2644 

[문제 링크](https://www.acmicpc.net/problem/2644) 

### 성능 요약

메모리: 14312 KB, 시간: 120 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색

### 제출 일자

2024년 2월 25일 15:08:33

### 문제 설명

<p>우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다. 이러한 촌수는 다음과 같은 방식으로 계산된다. 기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다. 예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.</p>

<p>여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.</p>

### 입력 

 <p>사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다. 입력 파일의 첫째 줄에는 전체 사람의 수 n이 주어지고, 둘째 줄에는 촌수를 계산해야 하는 서로 다른 두 사람의 번호가 주어진다. 그리고 셋째 줄에는 부모 자식들 간의 관계의 개수 m이 주어진다. 넷째 줄부터는 부모 자식간의 관계를 나타내는 두 번호 x,y가 각 줄에 나온다. 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.</p>

<p>각 사람의 부모는 최대 한 명만 주어진다.</p>

### 출력 

 <p>입력에서 요구한 두 사람의 촌수를 나타내는 정수를 출력한다. 어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 이때에는 -1을 출력해야 한다.</p>

---

Graph BFS 자료구조

```java
import java.util.Iterator;
import java.util.LinkedList;

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
}

```

위의 그래프 자료구조를 응용하여
양방향으로 관계를 만들어주고 queue에 촌수 정보를 담은 Person 객체를 담았다.

```java
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  static int N, M, answer;
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    answer = -1;

    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");

    // s와 target의 촌수를 구해야한다.
    int s = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(st.nextToken());

    M = Integer.parseInt(br.readLine());
    // 그래프 생성 (숫자가 1부터 시작하기 때문에 -> N + 1)
    Graph graph = new Graph(N + 1);

    // 간선을 이어준다. (양방향으로)
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int person1 = Integer.parseInt(st.nextToken());
      int person2 = Integer.parseInt(st.nextToken());

      graph.addEdge(person1, person2);
      graph.addEdge(person2, person1);
    }

    graph.BFS(s, target);

    System.out.println(answer);
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

    void BFS(int s, int target) {
      boolean visited[] = new boolean[V];
      LinkedList<Person> queue = new LinkedList<>();

      visited[s] = true;
      queue.add(new Person(s, 0));

      while (queue.size() != 0) {
        Person poll = queue.poll();
        int num = poll.num;
        int idx = poll.idx;

        // 큐에서 꺼낸 사람 숫자가 target과 같으면 촌수를 확인한다.
        if (num == target) {
          answer = idx;
          break;
        }

        Iterator<Integer> i = adj[num].listIterator();
        while (i.hasNext()) {
          int n = i.next();
          if (!visited[n]) {
            visited[n] = true;
            // 인접 노드에 촌수 정보를 넣어준다.
            queue.add(new Person(n, idx + 1));
          }
        }
      }
    }
  }

  static class Person {
    private int num;
    private int idx;

    Person(int num, int idx) {
      this.num = num;
      this.idx = idx;
    }
  }
}

```
