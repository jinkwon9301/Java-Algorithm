# [Gold II] 보석 도둑 - 1202 

[문제 링크](https://www.acmicpc.net/problem/1202) 

### 성능 요약

메모리: 114100 KB, 시간: 1928 ms

### 분류

자료 구조, 그리디 알고리즘, 우선순위 큐, 정렬

### 제출 일자

2024년 2월 4일 16:05:45

### 문제 설명

<p>세계적인 도둑 상덕이는 보석점을 털기로 결심했다.</p>

<p>상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 M<sub>i</sub>와 가격 V<sub>i</sub>를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 C<sub>i</sub>이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.</p>

<p>상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)</p>

<p>다음 N개 줄에는 각 보석의 정보 M<sub>i</sub>와 V<sub>i</sub>가 주어진다. (0 ≤ M<sub>i</sub>, V<sub>i</sub> ≤ 1,000,000)</p>

<p>다음 K개 줄에는 가방에 담을 수 있는 최대 무게 C<sub>i</sub>가 주어진다. (1 ≤ C<sub>i</sub> ≤ 100,000,000)</p>

<p>모든 숫자는 양의 정수이다.</p>

### 출력 

 <p>첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.</p>
 
---

<img width="760" alt="Screenshot 2024-02-04 at 3 48 45 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/85749c3f-d956-40a8-9356-e5dabb0100d4">
<img width="755" alt="Screenshot 2024-02-04 at 3 48 53 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/118a1825-7462-4466-9aa4-a78ad797f6a4">

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Jewelry {
    int mass; // 무게
    int value; // 가격
 
    Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        Jewelry[] jewelries = new Jewelry[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
 
            jewelries[i] = new Jewelry(m, v);
        }
        // 무게를 오름차순 정렬하되, 무게가 같을 경우 가격을 내림차순 정렬.
        Arrays.sort(jewelries, new Comparator<Jewelry>() {
 
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.mass == o2.mass) {
                    return o2.value - o1.value;
                }
                return o1.mass - o2.mass;
            }
 
        });
 
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        // 가방의 무게를 오름차순 정렬
        Arrays.sort(bags);
 
        // 우선순위 큐는 항상 가격이 내림차순 정렬되도록 설정.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < K; i++) {
            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음.
            while (j < N && jewelries[j].mass <= bags[i]) {
                pq.offer(jewelries[j++].value);
            }
 
            // 우선순위 큐에 있는 요소를 하나 빼서 가방에 넣음.
            // 이 때, 우선순위 큐는 내림차순 정렬이 되어있으므로
            // 첫 번째 요소는 가장 큰 가격을 의미함.
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}
```

출처 : [[BOJ] 백준 1202번 : 보석 도둑 (JAVA)](https://steady-coding.tistory.com/56)
