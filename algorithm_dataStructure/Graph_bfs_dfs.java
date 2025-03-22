package com.example.hello.codingTest.datastructure.self;

import java.util.LinkedList;
import java.util.ListIterator;

public class Graph_bfs_dfs {
  public static void main(String[] args) {

  }

  private static class Graph {
    int v;
    LinkedList<Integer> adj[];
    boolean[] visited;

    public Graph(int v) {
      v = v;
      adj = new LinkedList[v];
      visited = new boolean[v];
      for (int i = 0; i < v; i++) {
        adj[i] = new LinkedList<>();
      }
    }

    void addEdge(int v, int w) {adj[v].add(w);}

    void BFS(int init) {
      // BFS는 간선으로 이어진 인접한 정점부터 방문하는 것이기 때문에 queue 사용.
      LinkedList<Integer> queue = new LinkedList<>();
      // 방문했는지 체크하기 위한 boolean 배열 생성.

      // 파라미터로 받은 정점을 방문한다.
      visited[init] = true;
      // 큐에 넣어준다
      queue.add(init);

      while (!queue.isEmpty()) {
        Integer current = queue.poll();
        System.out.println("방문 정점 = " + current);

        // 꺼낸 정점의 인접 정점들을 꺼낸다.
        ListIterator<Integer> iterator = adj[current].listIterator();
        while (iterator.hasNext()) {
          // 만약 방문하지 않은 정점이라면 큐에 넣는다.
          Integer next = iterator.next();
          if (!visited[next]) {
            visited[next] = true;
            queue.add(next);
          }
        }
      }
    }

    void DFS(int current) {
      // 파라미터로 받은 정점 방문
      visited[current] = true;
      System.out.println("방문 정점 = " + current);

      ListIterator<Integer> iterator = adj[current].listIterator();
      while (iterator.hasNext()) {
        Integer next = iterator.next();
        if (!visited[next]) {
          DFS(next);
        }
      }
    }
  }
}
