# [Gold I] 멀티탭 스케줄링 - 1700 

[문제 링크](https://www.acmicpc.net/problem/1700) 

### 성능 요약

메모리: 15772 KB, 시간: 140 ms

### 분류

그리디 알고리즘

### 제출 일자

2024년 2월 5일 16:25:48

### 문제 설명

<p>기숙사에서 살고 있는 준규는 한 개의 멀티탭을 이용하고 있다. 준규는 키보드, 헤어드라이기, 핸드폰 충전기, 디지털 카메라 충전기 등 여러 개의 전기용품을 사용하면서 어쩔 수 없이 각종 전기용품의 플러그를 뺐다 꽂았다 하는 불편함을 겪고 있다. 그래서 준규는 자신의 생활 패턴을 분석하여, 자기가 사용하고 있는 전기용품의 사용순서를 알아내었고, 이를 기반으로 플러그를 빼는 횟수를 최소화하는 방법을 고안하여 보다 쾌적한 생활환경을 만들려고 한다.</p>

<p>예를 들어 3 구(구멍이 세 개 달린) 멀티탭을 쓸 때, 전기용품의 사용 순서가 아래와 같이 주어진다면, </p>

<ol>
	<li>키보드</li>
	<li>헤어드라이기</li>
	<li>핸드폰 충전기</li>
	<li>디지털 카메라 충전기</li>
	<li>키보드</li>
	<li>헤어드라이기</li>
</ol>

<p>키보드, 헤어드라이기, 핸드폰 충전기의 플러그를 순서대로 멀티탭에 꽂은 다음 디지털 카메라 충전기 플러그를 꽂기 전에 핸드폰충전기 플러그를 빼는 것이 최적일 것이므로 플러그는 한 번만 빼면 된다. </p>

### 입력 

 <p>첫 줄에는 멀티탭 구멍의 개수 N (1 ≤ N ≤ 100)과 전기 용품의 총 사용횟수 K (1 ≤ K ≤ 100)가 정수로 주어진다. 두 번째 줄에는 전기용품의 이름이 K 이하의 자연수로 사용 순서대로 주어진다. 각 줄의 모든 정수 사이는 공백문자로 구분되어 있다. </p>

### 출력 

 <p>하나씩 플러그를 빼는 최소의 횟수를 출력하시오. </p>

---

<img width="754" alt="Screenshot 2024-02-05 at 3 23 50 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/99849b73-07d3-433f-8ede-1fcae2dc60c8">

정답 코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        int[] order = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
 
        boolean[] use = new boolean[101];
        int put = 0;
        int ans = 0;
        for (int i = 0; i < K; i++) {
            int temp = order[i];
 
            if (!use[temp]) { // 콘센트가 꽂혀있지 않은 경우
                if (put < N) { // 콘센트를 꽂을 공간이 있는 경우
                    use[temp] = true;
                    put++;
                } else { // 콘센트를 꽂을 공간이 없는 경우
                    ArrayList<Integer> arrList = new ArrayList<>();
                    for (int j = i; j < K; j++) { // 현재 꽂혀 있는 콘센트가 나중에도 사용되는지 확인.
                        if (use[order[j]] && !arrList.contains(order[j])) {
                            arrList.add(order[j]);
                        }
                    }
 
                    if (arrList.size() != N) { // 나중에도 사용되는 콘센트가 구멍의 개수보다 작을 경우.
                        for (int j = 0; j < use.length; j++) {
                            if (use[j] && !arrList.contains(j)) { // 그 콘센트를 제거.
                                use[j] = false;
                                break;
                            }
                        }
                    } else { // 현재 꽂혀 있는 모든 콘센트가 나중에도 사용될 경우
                        int remove = arrList.get(arrList.size() - 1); // 가장 마지막에 사용될 콘센트를 제거.
                        use[remove] = false;
                    }
 
                    use[temp] = true;
                    ans++;
                }
            }
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}
```

내가 푼 코드 (17퍼에서 끊김)
```java
package com.example.hello.codingTest;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

  static int N = 0;
  static int K = 0;
  static int[] arr;
  static boolean[] visited;
  static boolean[] nVisited;
  static int count = 0;
  static int nCount = 0;
  static int target = 0;
  static int result = 0;
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    // 초기화
    arr = new int[K];
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < K; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    visited = new boolean[101];

    // 코드를 꽂는다.
    for (int i = 0; i < K; i++) {
      int cord = arr[i];
      // 멀티탭의 코드가 아직 남았다면 코드를 꽂는다.
      if (count < N) {
        if (!visited[cord]) {
          visited[cord] = true;
          count++;
        }
      }
      // 멀티탭의 코드가 전부 사용중이라면 갱신할 코드를 찾는다.
      // 남은 전기기구 사용 일정 중 가장 후순위의 코드가 갱신 후보다.
      else {
        // 만약 사용해야 할 코드가 이미 꽂혀있다면 무시하고 넘어간다.
        if (visited[cord]) continue;
        // 코드 사용상태를 확인하는 배열을 복사한다.
        nVisited = visited.clone();
        nCount = N;

        // 코드 사용 스케쥴 중 먼저 사용되는 코드들을 확인한다.
        for (int j = i; j < K; j++) {
          int nCord = arr[j];
          if (nVisited[nCord]) {
            nVisited[nCord] = false;
            nCount--;
            // 남은 사용일정중 먼저 사용되는 코드들을 확인하다가 마지막 코드가 남으면 그 코드가 갱신 대상이다.
            if (nCount == 1) {
              for (int k = 0; k < 101; k++) {
                if (nVisited[k]) {
                  target = k;
                  break;
                }
              }
              break;
            }
          }
        }

        // 만약 코드일정들을 모두 순회했는데 꽂을 계획없는 코드가 2개 이상 있는 경우 target 설정
        if (nCount > 1) {
          for (int k = 0; k < 101; k++) {
            if (nVisited[k]) {
              target = k;
              break;
            }
          }
        }

        // 코드를 바꿔끼고 횟수 추가
        visited[target] = false;
        visited[cord] = true;
        result++;
      }
    }

    System.out.println(result);
  }
}
```

출처 : [https://steady-coding.tistory.com/55]([BOJ] 백준 1700번 : 멀티탭 스케줄링 (JAVA))
