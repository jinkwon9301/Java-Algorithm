# [Silver I] 부등호 - 2529 

[문제 링크](https://www.acmicpc.net/problem/2529) 

### 성능 요약

메모리: 27196 KB, 시간: 272 ms

### 분류

백트래킹, 브루트포스 알고리즘

### 제출 일자

2024년 1월 24일 18:10:46

### 문제 설명

<p>두 종류의 부등호 기호 ‘<’와 ‘>’가 k개 나열된 순서열 A가 있다. 우리는 이 부등호 기호 앞뒤에 서로 다른 한 자릿수 숫자를 넣어서 모든 부등호 관계를 만족시키려고 한다. 예를 들어, 제시된 부등호 순서열 A가 다음과 같다고 하자. </p>

<p style="text-align: center;">A ⇒ < < < > < < > < ></p>

<p>부등호 기호 앞뒤에 넣을 수 있는 숫자는 0부터 9까지의 정수이며 선택된 숫자는 모두 달라야 한다. 아래는 부등호 순서열 A를 만족시키는 한 예이다. </p>

<p style="text-align: center;"><strong>3 < 4 < 5 < 6 > 1 < 2 < 8 > 7 < 9 > 0</strong></p>

<p>이 상황에서 부등호 기호를 제거한 뒤, 숫자를 모두 붙이면 하나의 수를 만들 수 있는데 이 수를 주어진 부등호 관계를 만족시키는 정수라고 한다. 그런데 주어진 부등호 관계를 만족하는 정수는 하나 이상 존재한다. 예를 들어 3456128790 뿐만 아니라 5689023174도 아래와 같이 부등호 관계 A를 만족시킨다. </p>

<p style="text-align: center;"><strong>5 < 6 < 8 < 9 > 0 < 2 < 3 > 1 < 7 > 4</strong></p>

<p>여러분은 제시된 k개의 부등호 순서를 만족하는 (k+1)자리의 정수 중에서 최댓값과 최솟값을 찾아야 한다. 앞서 설명한 대로 각 부등호의 앞뒤에 들어가는 숫자는 { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }중에서 선택해야 하며 <u><strong>선택된 숫자는 모두 달라야 한다</strong></u>. </p>

### 입력 

 <p>첫 줄에 부등호 문자의 개수를 나타내는 정수 k가 주어진다. 그 다음 줄에는 k개의 부등호 기호가 하나의 공백을 두고 한 줄에 모두 제시된다. k의 범위는 2 ≤ k ≤ 9 이다. </p>

### 출력 

 <p>여러분은 제시된 부등호 관계를 만족하는 k+1 자리의 최대, 최소 정수를 첫째 줄과 둘째 줄에 각각 출력해야 한다. 단 아래 예(1)과 같이 첫 자리가 0인 경우도 정수에 포함되어야 한다. 모든 입력에 답은 항상 존재하며 출력 정수는 하나의 문자열이 되도록 해야 한다. </p>

---

```java
package com.example.hello.codingTest;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int k = 0;
  static long max = 0;
  static long min = 9999999999L;
  static String maxSring = "";
  static String minSring = "";
  static String[] inequalities;
  static int[] visited;
  static boolean[] usedNumber;

  public static void main(String[] args) throws IOException{
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    k = Integer.parseInt(br.readLine());
//    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//    inequalities = new String[k];
//    for (int i = 0; i < k; i++) {
//      inequalities[i] = st.nextToken();
//    }

    k = 2;
    inequalities = new String[]{"<", "<"};

    k = 9;
    inequalities = new String[]{">" ,"<" ,"<" ,"<" ,">" ,">" ,">" ,"<" ,"<"};

    visited = new int[k + 1];
    usedNumber = new boolean[10];

    for (int i = 0; i < 10; i++) {
      visited[0] = i;
      usedNumber[i] = true;
      dfs(i, 0);
      usedNumber[i] = false;
    }

    System.out.println(maxSring);
    System.out.println(minSring);
  }

  static void dfs(int num, int idx) {

    if (idx == k) {
      visited[k] = num;
      String total = "";
      for (int i = 0; i < visited.length; i++) {
        total += visited[i];
      }
      long total_int = Long.parseLong(total);
      max = Math.max(max, total_int);
      if (max == total_int) maxSring = total;
      min = Math.min(min, total_int);
      if (min == total_int) minSring = total;
      return;
    }

    String inequality = inequalities[idx];

    if (inequality == "<") {
      for (int i = num + 1; i < 10; i++) {
        if (usedNumber[i] == false) {
          visited[idx + 1] = i;
          usedNumber[i] = true;
          dfs(i, idx + 1);
          usedNumber[i] = false;
        }
      }
    } else {
      for (int i = 0; i < num; i++) {
        if (usedNumber[i] == false) {
          visited[idx + 1] = i;
          usedNumber[i] = true;
          dfs(i, idx + 1);
          usedNumber[i] = false;
        }
      }
    }
  }
}
```
같은 풀이인거 같은데 이건 틀리다
