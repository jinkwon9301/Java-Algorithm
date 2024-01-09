# [Gold V] 전구와 스위치 - 2138 

[문제 링크](https://www.acmicpc.net/problem/2138) 

### 성능 요약

메모리: 19548 KB, 시간: 232 ms

### 분류

그리디 알고리즘

### 제출 일자

2024년 1월 9일 13:22:45

### 문제 설명

<p>N개의 스위치와 N개의 전구가 있다. 각각의 전구는 켜져 있는 상태와 꺼져 있는 상태 중 하나의 상태를 가진다. i(1 < i < N)번 스위치를 누르면 i-1, i, i+1의 세 개의 전구의 상태가 바뀐다. 즉, 꺼져 있는 전구는 켜지고, 켜져 있는 전구는 꺼지게 된다. 1번 스위치를 눌렀을 경우에는 1, 2번 전구의 상태가 바뀌고, N번 스위치를 눌렀을 경우에는 N-1, N번 전구의 상태가 바뀐다.</p>

<p>N개의 전구들의 현재 상태와 우리가 만들고자 하는 상태가 주어졌을 때, 그 상태를 만들기 위해 스위치를 최소 몇 번 누르면 되는지 알아내는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 자연수 N(2 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 전구들의 현재 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 그 다음 줄에는 우리가 만들고자 하는 전구들의 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 0은 켜져 있는 상태, 1은 꺼져 있는 상태를 의미한다.</p>

### 출력 

 <p>첫째 줄에 답을 출력한다. 불가능한 경우에는 -1을 출력한다.</p>

---

| 풀이

  만약 i번 스위치를 누르면 i번 스위치만 변경된다고 해보자. 이 경우 000 에서 010 으로 만들려면 어떻게 해야 할까? 자명하게도 그냥 좌측부터 서로 비교해보면서 서로 다른걸 누르면 되므로 1번만 누르면 된다.

 

  그럼 i번 스위치를 누르면 i번과 i+1번이 변경된다고 해보자. 이 경우에도 마찬가지로, 그냥 문자열의 좌측부터 서로 비교해보면서 i번이 다르다면 무조건 누르면 된다! 왜냐면 i가 증가하는 순서대로 보고 있는경우, i번이 다를 때 누르지 않고 넘어가게 하면 i번을 변경할 기회가 전혀 없기 때문이다. 따라서 000에서 010으로 변경하려면 000 -> 011 -> 010 처럼 총 2번을 눌러야 할 것이다.

 

  근데 이 문제는 i번을 누르면 i-1과 i+1이 변경되므로 위와 다르게 i가 증가해도 이전값이 변경될 수 있으므로 다를까? 아니다. 그냥 동일한거다. i-1, i, i+1 이 변경되는 것 대신 그냥 i, i+1, i+2 이 변경된다고 문제를 변형해도 전혀 문제가 없다. 이 경우 다만 기존의 1번 스위치를 눌러 1,2번 스위치를 변경하는 연산은 불가능하다. (i가 0번 스위치를 누를 순 없으므로)

 

  따라서 그냥 두 경우 다 보면 된다. 어차피 O(N)이나 O(N+N)이나 별 차이 없다. 정리하면 다음과 같다.

1. i-1, i, i+1 을 변경하는 것을 -> i, i+1, i+2 를 변경하는 걸로 바꿔서생각하자.

 

2. 이 경우 1번 스위치를 눌러서 1,2번이 변경되는 연산은 불가능하므로 그냥 두 경우 다 살펴보면 된다. 즉, 1,2번 스위치를 그대로 둔채 로직을 돌리고, 1,2번 스위치를 누른채로 로직을 돌려보면 된다.

 

3. 위에서 설명했듯이 i를 기준으로 그 우측의 스위치가 켜지도록 생각을 변경해보면, i = 1부터 i = N 까지 증가하면서 살펴보다가 i번째가 서로 다르면 그냥 무조건 스위치를 누르면 된다(그리디). 그것보다 빠르게 변경은 불가하다. i가 일단 증가해버리면 그 이전의 스위치는 변경될 기회 자체가 없기 때문이다.

 

4. 스위치를 누를 수 있는 구간까지 진행해보고(i, i+1, i+2로 변경했으므로 끝에서 2번째까지 누를 수 있다), 가장 끝의 문자가 서로 다르면 불가능한 경우이다. 누를 수 없기 때문이다.

```java
int[] a = new int[n];
for (int i = 0; i < n; i++) a[i] = s1.charAt(i)-'0';	// a는 1번 스위치를 안누른 경우이다.
int[] b = new int[n];
for (int i = 0; i < n; i++) b[i] = s2.charAt(i)-'0';

int[] c = Arrays.copyOf(a, n);	// c는 1번 스위치를 누른 경우이다.
c[0] = 1-c[0];
c[1] = 1-c[1];

int answer = solve(n, a, b);	// 1번 스위치 안누른 경우에 대해 진행
int answer2 = solve(n, c, b);	// 1번 스위치 누른 경우에 대해 진행
```

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    private void solution() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = s1.charAt(i)-'0';
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = s2.charAt(i)-'0';

        int[] c = Arrays.copyOf(a, n);
        c[0] = 1-c[0];
        c[1] = 1-c[1];

        int answer = solve(n, a, b);
        int answer2 = solve(n, c, b);
        if (answer2 != -1) answer2++;

        if (answer == -1)
            System.out.println(answer2);
        else if (answer2 == -1)
            System.out.println(answer);
        else
            System.out.println(Math.min(answer2, answer));
    }

    private int solve(int n, int[] a, int[] b) {
        int cnt = 0;

        for (int i = 0; i < n-1; i++) {
            if (a[i]!=b[i]) {
                cnt++;
                a[i] = 1-a[i];
                a[i+1] = 1-a[i+1];
                if (i != n-2)
                    a[i+2] = 1-a[i+2];
            }
        }

        return a[n-1]!=b[n-1] ? -1 : cnt;

    }
}
```

출처 : [[자바] 백준 2138 - 전구와 스위치 (java)](https://nahwasa.com/entry/%EC%9E%90%EB%B0%94-%EB%B0%B1%EC%A4%80-2138-%EC%A0%84%EA%B5%AC%EC%99%80-%EC%8A%A4%EC%9C%84%EC%B9%98-java)
