# [Gold V] A와 B 2 - 12919 

[문제 링크](https://www.acmicpc.net/problem/12919) 

### 성능 요약

메모리: 14228 KB, 시간: 128 ms

### 분류

브루트포스 알고리즘, 재귀, 문자열

### 제출 일자

2024년 1월 30일 13:55:16

### 문제 설명

<p>수빈이는 A와 B로만 이루어진 영어 단어 존재한다는 사실에 놀랐다. 대표적인 예로 AB (Abdominal의 약자), BAA (양의 울음 소리), AA (용암의 종류), ABBA (스웨덴 팝 그룹)이 있다.</p>

<p>이런 사실에 놀란 수빈이는 간단한 게임을 만들기로 했다. 두 문자열 S와 T가 주어졌을 때, S를 T로 바꾸는 게임이다. 문자열을 바꿀 때는 다음과 같은 두 가지 연산만 가능하다.</p>

<ul>
	<li>문자열의 뒤에 A를 추가한다.</li>
	<li>문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.</li>
</ul>

<p>주어진 조건을 이용해서 S를 T로 만들 수 있는지 없는지 알아내는 프로그램을 작성하시오. </p>

### 입력 

 <p>첫째 줄에 S가 둘째 줄에 T가 주어진다. (1 ≤ S의 길이 ≤ 49, 2 ≤ T의 길이 ≤ 50, S의 길이 < T의 길이)</p>

### 출력 

 <p>S를 T로 바꿀 수 있으면 1을 없으면 0을 출력한다.</p>

---

```java
import java.io.*;

public class Main {

  static StringBuffer S;
  static String T = "";
  static boolean isPossible = false;

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    S = new StringBuffer(br.readLine());
    T = br.readLine();

//    S = new StringBuffer("A");
//    T = "BABA";
//
//    S = new StringBuffer("BAAAAABAA");
//    T = "BAABAAAAAB";
//
//    S = new StringBuffer("A");
//    T = "ABBA";

    dfs(S);

    if (isPossible) {
      System.out.println(1);
      return;
    }

    System.out.println(0);
  }

  static void dfs(StringBuffer sb) {
    // str의 길이가 T의 길이가 되면 종료
    if (sb.length() == T.length()) {
      if (sb.toString().equals(T)) isPossible = true;
      return;
    }

    // A를 추가하거나
    dfs(sb.append("A"));
    // 탐색 끝나면 원상복구
    sb.deleteCharAt(sb.length() - 1);

    // B를 추가하고 뒤집기
    dfs(sb.append("B").reverse());
    // 탐색 끝나면 원상복구
    sb.reverse().deleteCharAt(sb.length() - 1);
  }
}
```
처음 풀었던 풀이

S → T 로 가려고 했다.
그러면 A를 추가하는 경우, B를 추가하고 뒤집는 경우 모두 거쳐야 하기 때문에 2⁵⁰ 의 경우의 수가 나온다. → 시간 초과

T → S 로 가면
T의 마지막이 A인 경우만 A를 뺄 수 있고
T의 처음이 B인 경우만 뒤집고 B를 뺄 수 있다.
경우의 수를 줄일 수 있다.

참고 : [참고 블로그 1](https://velog.io/@pppp0722/%EB%B0%B1%EC%A4%80-%EA%B3%A8%EB%93%9C5-12919-A%EC%99%80-B-2-Java)
참고 : [참고 블로그 2](https://velog.io/@dlsrjsdl6505/%EB%B0%B1%EC%A4%80-12919-A%EC%99%80-B2-%EC%9E%90%EB%B0%94)
