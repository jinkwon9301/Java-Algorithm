# [Silver II] DOM - 10552 

[문제 링크](https://www.acmicpc.net/problem/10552) 

### 성능 요약

메모리: 44260 KB, 시간: 368 ms

### 분류

너비 우선 탐색, 깊이 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 2월 11일 16:43:59

### 문제 설명

<p>In a retirement home, N senior citizens are watching television. The television programme consists of M channels denoted with numbers from 1 to M. Each of the pensioners has their own favourite and hated TV channel.</p>

<p>If the television is currently displaying the hated channel of a certain pensioner, he will get up, slowly walk over to the TV set and change the channel to his favourite and get back to his comfortable chair. If there are multiple pensioners who hate the current channel, the youngest of them will get up (he’s young, he doesn’t mind) and the rest will remain seated.</p>

<p>Of course, after one change of channel, it is possible that another pensioner finds the new channel intolerable so he will change that channel. Given the fact that the pensioners are stubborn, this may continue indefinitely.</p>

<p>For the pensioners’ favourite and hated channels and the initial channel on TV, determine the number of channel changes it takes for the pensioners to remain happy and seated.</p>

### 입력 

 <p>The first line of input contains three integers N, M and P (1 ≤ N, M ≤ 10<sup>5</sup>, 1 ≤ P ≤ M), the number of pensioners, the number of TV channels and the initial channel displayed on TV.</p>

<p>Each of the following N lines contains two integers a<sub>i</sub> and b<sub>i</sub> (1 ≤ a<sub>i</sub>, b<sub>i</sub> ≤ M, a<sub>i</sub> ≠ b<sub>i</sub>), the favourite and hated channel of each pensioner.</p>

<p>The ordering of pensioners in the input is from the youngest to the oldest.</p>

### 출력 

 <p>The first and only line of output must contain the required number of channel changes. If the changes continue indefinitely, output -1.</p>

---

```java
// Error: (StackOverflow)
package com.example.hello.codingTest;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int N, M, P;
  static ArrayList<Integer>[] graph;
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());

    // 그래프 초기화 (채널들을 정점으로 그래프 만든다.)
    graph = new ArrayList[M + 1];

    for (int i = 0; i < M + 1; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int favorite = Integer.parseInt(st.nextToken());
      int hate = Integer.parseInt(st.nextToken());

      // 싫어하는 채널에서 좋아하는 채널로 바꿀 수 있도록 그래프를 완성해준다.
      // 만약 특정 채널을 싫어하는 사람들이 많다면 가장 어린 애가 좋아하는 채널이 입력되도록
      if (graph[hate].size() == 0) {
        graph[hate].add(favorite);
      }
    }

    dfs(P, P, 0);
  }

  private static void dfs(int now, int start, int count) {
    // 종료조건
    // 지금 이 채널을 싫어하는 사람이 없다면 채널변경 횟수(count) 보여주고 중단한다.
    if(graph[now].size() == 0) {
      System.out.println(count);
      return;
    }

    // 무한순환하는 경우에는 -1 보여주고 중단한다.
    if (count != 0 && now == start) {
      System.out.println(-1);
      return;
    }

    dfs(graph[now].get(0), start, count + 1);
  }
}

```

이렇게 visited 배열을 사용하지 않고 풀면 (1 → 2 → 3 → 2 → 3 이렇게 순환하는 케이스를 못잡아내서) 무한하게 dfs 스택이 쌓여서 StackOverFlow 에러가 난다.
