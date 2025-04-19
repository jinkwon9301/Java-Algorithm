# [Silver I] 오르막 수 - 11057 

[문제 링크](https://www.acmicpc.net/problem/11057) 

### 성능 요약

메모리: 14288 KB, 시간: 104 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 4월 19일 17:50:40

### 문제 설명

<p>오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.</p>

<p>예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.</p>

<p>수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.</p>

### 입력 

 <p>첫째 줄에 N (1 ≤ N ≤ 1,000)이 주어진다.</p>

### 출력 

 <p>첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.</p>

---

/*
Q: 백준 오르막수 문제에서 백트래킹(dfs)을 사용하면 시간초과 나는이유


ChatGPT said:
좋은 질문이야! 백준 오르막수 문제(BOJ 11057)에서 백트래킹(DFS) 방식으로 접근하면 시간초과가 나는 이유는 탐색 경우의 수가 매우 많기 때문이야.

🔍 문제 요약
0부터 9까지의 숫자 중에서 오름차순으로 이루어진 길이 N의 수의 개수를 구하는 문제.
오르막 수: 자릿수가 증가하거나 같아야 함 (ex. 2234, 11119 가능).
예: N = 2일 때 가능한 오르막 수는 00, 01, 02, ..., 09, 11, 12, ..., 99 → 총 55개.

🧠 DFS(백트래킹)로 풀면 왜 느릴까?
1. 탐색 분기 수
DFS로 하면 모든 가능한 숫자 조합을 탐색해야 해.
각 자리마다 선택 가능한 숫자는 이전 숫자보다 크거나 같아야 하니까,
가능한 경우를 일일이 다 재귀적으로 탐색하게 돼.

```java
void dfs(int depth, int prevDigit) {
    if (depth == N) {
        count++;
        return;
    }

    for (int i = prevDigit; i <= 9; i++) {
        dfs(depth + 1, i);
    }
}
```

첫 자리: 0~9 (10가지)
두 번째 자리: 현재 숫자 이상 (최대 10가지)
세 번째 자리: ...
⇒ 결국 중복되는 연산이 엄청 많고, 시간 복잡도는 O(10^N) 수준까지 감.

예를 들어 N=1000이면, DFS는 10^1000에 가까운 탐색을 하게 돼.
=> 절대 시간 안에 끝날 수 없어 (시간초과 💥)

✅ 이 문제는 DP(동적 프로그래밍) 으로 풀어야 함
중복 계산을 방지하고, 하위 문제의 결과를 재활용해야 효율적으로 풀 수 있어.

🎯 핵심 아이디어
dp[i][j] = 길이가 i이고, 마지막 숫자가 j인 오르막수의 개수

점화식:
dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + ... + dp[i-1][0]
(즉, 이전 자릿수에서 현재 숫자보다 작거나 같은 숫자들의 합)

최종 정답:
sum(dp[N][0] ~ dp[N][9])

```java
package com.example.hello.codingTest;

import java.io.*;

class Main {
  static int N;
  static final int MOD = 10007;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    // dp[i][j] = 길이가 i이고, 마지막 숫자가 j인 오르막 수 개수
    int[][] dp = new int[N + 1][10];

    // 초기값: 길이가 1일 때는 0~9 각각 하나씩 가능
    for (int j = 0; j <= 9; j++) {
      dp[1][j] = 1;
    }

    // 점화식 적용
    // 일단 길이 2부터 N까지 채워야 한다. (길이 1은 이미 채움)
    for (int i = 2; i < N; i++) {
      for (int j = 0; j < 10; j++) {
        for (int k = 0; k <= j; k++) {
          dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
        }
      }
    }

    // 정답: 길이 N에서 끝자리가 0~9인 수의 합
    int result = 0;
    for (int j = 0; j <= 9; j++) {
      result = (result + dp[N][j]) % MOD;
    }

    System.out.println(result);
  }
}

```
