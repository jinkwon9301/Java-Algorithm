# [Gold IV] 숨바꼭질 2 - 12851 

[문제 링크](https://www.acmicpc.net/problem/12851) 

### 성능 요약

메모리: 21984 KB, 시간: 204 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 3월 17일 15:12:37

### 문제 설명

<p>수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.</p>

<p>수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 그리고, 가장 빠른 시간으로 찾는 방법이 몇 가지 인지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.</p>

### 출력 

 <p>첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.</p>

<p>둘째 줄에는 가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수를 출력한다.</p>

---

<img width="987" alt="Screenshot 2024-03-17 at 3 18 15 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/dd188a29-dd52-44ed-8466-85133404b097">
<img width="981" alt="Screenshot 2024-03-17 at 3 18 35 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/f906d71b-4adb-418c-9bcd-b1ec8aef4e70">
<img width="979" alt="Screenshot 2024-03-17 at 3 19 04 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/24c9d531-4c6c-4608-af7f-9a4ebff7c587">


```java
import java.util.*;
import java.io.*;

class Main {
    static int N, K;
    static int[] time = new int[100001];
    static int minTime = 987654321;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }

        bfs();

        System.out.println(minTime + "\n" + count);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(N);
        time[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            // now 방문 시간이 최소 시간보다 크면 뒤는 더 볼 필요 없음
            if (minTime < time[now]) return;

            for (int i=0; i<3; i++) {
                int next;

                if (i == 0)         next = now + 1;
                else if (i == 1)    next = now - 1;
                else                next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (next == K) {
                    minTime = time[now];
                    count++;
                }

                // 첫 방문이거나 (time[next] == 0)
                // 이미 방문한 곳이어도 같은 시간에 방문했다면 (time[next] == time[now] + 1)
                // 경우의 수에 추가될 수 있기 때문에 Queue 에 한번 더 넣어줌
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    q.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}
```

출처 :[뱀귤 블로그](https://bcp0109.tistory.com/154)
