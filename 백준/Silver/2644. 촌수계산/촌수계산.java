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

