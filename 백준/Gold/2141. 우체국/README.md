# [Gold IV] 우체국 - 2141 

[문제 링크](https://www.acmicpc.net/problem/2141) 

### 성능 요약

메모리: 47056 KB, 시간: 568 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2024년 1월 12일 13:21:03

### 문제 설명

<p>수직선과 같은 일직선상에 N개의 마을이 위치해 있다. i번째 마을은 X[i]에 위치해 있으며, A[i]명의 사람이 살고 있다.</p>

<p>이 마을들을 위해서 우체국을 하나 세우려고 하는데, 그 위치를 어느 곳으로 할지를 현재 고민 중이다. 고민 끝에 나라에서는 각 사람들까지의 거리의 합이 최소가 되는 위치에 우체국을 세우기로 결정하였다. 우체국을 세울 위치를 구하는 프로그램을 작성하시오.</p>

<p>각 마을까지의 거리의 합이 아니라, 각 사람까지의 거리의 합임에 유의한다</p>

### 입력 

 <p>첫째 줄에 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 X[1], A[1], X[2], A[2], …, X[N], A[N]이 주어진다. 범위는 |X[i]| ≤ 1,000,000,000, 1 ≤ A[i] ≤ 1,000,000,000 이며 모든 입력은 정수이다.</p>

### 출력 

 <p>첫째 줄에 우체국의 위치를 출력한다. 가능한 경우가 여러 가지인 경우에는 더 작은 위치를 출력하도록 한다.</p>

---

접근 방법
이 문제에 핵심
1. 나라에서 각 사람들까지의 거리의 합이 최소가 되는 위치에 우체국을 세웁니다.
2. 우체국을 세울 위치를 결과로 출력합니다.
3. 각 마을까지의 거리의 합이 아니라, 각 사람까지의 거리의 합입니다.
4. 가능한 경우가 여러 가지인 경우 더 작은 위치를 출력하도록 합니다.
 
알고리즘 진행 순서.
 
1. 입력된 정보를 저장합니다.
 
2. 사람들의 수를 기준으로 가장 적절한 우체국의 위치를 탐색합니다.
 
3. 우체국을 세울 위치를 결과로 출력합니다.
 
우체국 위치 탐색
 
각 사람들의 거리의 합이 최소가 되려면?
 
→ 해당 마을을 기준으로 왼쪽, 오른쪽의 사람의 수가 균일해야 합니다.
 
즉, 우체국의 위치가  총 인구수의 중간값의 가장 가까운 마을에 우체국이 설치되어야 합니다.
 
→ 중간값을 구한 뒤 위치가 작은 값부터 탐색해서 처음으로 중간값보다 크거나 같아지는 마을이 우체국을 설치할 위치입니다.
 
예제입력 1.
1. 입력된 정보를 저장합니다.
N : 3

![R1280x0](https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/e22ab61c-2911-4f04-8720-deabe6c0f700)

2. 사람들의 수를 기준으로 가장 적절한 우체국의 위치를 탐색합니다.
 
총 인원수 : 11명
 
중간값 : 6

![R1280x0](https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/9e1a4935-8ad8-4935-84c7-3e0233ace56c)

인원 수 : 3명 < 6명(중간값)
→ 해당 마을은 우체국 설치 X

![R1280x0](https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/7b23dd32-1bc3-4d3d-926b-b1ae3160435f)

인원 수 : 8명 ≥ 6명(중간값)
→ 해당 마을은 처음으로 중간값보다 크거나 같으므로 해당 마을에 우체국 설치!
 
3. 우체국을 세울 위치를 결과로 출력합니다.
 
2번째 마을의 위치에 우체국을 설치합니다.
 
2번째 마을의 위치 : 2
 
2 을 결과로 출력합니다.
 
* BufferedReader를 사용하여 입력되는 정보를 저장합니다.
* StringTokenizer를 이용하여 마을의 정보를 저장합니다.
* 총 사람 수 기준 중간값을 기준으로 마을들을 탐색합니다.
* 탐색이 끝난 뒤 우체국을 설치할 마을의 위치를 BufferedWriter에 저장합니다.
* BufferedWriter에 저장된 결과를 출력합니다.
 
결과코드
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //마을 관련 클래스
    static class House implements Comparable<House>{
        long pos, val;
        public House(long pos, long val){
            this.pos = pos;
            this.val = val;
        }
        //마을 위치 기준 오름차순 정렬 기준
        @Override
        public int compareTo(House o) {
            return (int) (this.pos - o.pos);
        }
    }
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //마을 정보 저장 리스트
        List<House> houseList = new ArrayList<>();
        long sum = 0;
        //마을 정보들 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            long pos  = Long.parseLong(st.nextToken());
            long val = Long.parseLong(st.nextToken());
            houseList.add(new House(pos, val));
            sum += val;	//총 인원 구하기
        }
        Collections.sort(houseList);	//마을 위치 기준 오름차순 정렬
        long result = 0;
        //가장 먼저 중간값보다 크거나 같은 마을 탐색
        for(int i=0;i<N;i++){
            result += houseList.get(i).val;
            if((sum + 1)/2 <= result){	//(sum+1)/2 : 중간값
                bw.write(String.valueOf(houseList.get(i).pos));
                break;
            }
        }
        bw.flush();	//결과 출력
        bw.close();
        br.close();
    }
}
```

출처 : [[백준, Java] 2141번, 우체국(그리디)](https://tussle.tistory.com/1050)

---

이분탐색 풀이법

```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    int n = Integer.parseInt(br.readLine());
    ArrayList<Pair> al = new ArrayList<>();
    long[] sum = new long[n];

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());

      al.add(new Pair(x, a));
    }

    Collections.sort(al, (Pair a1, Pair a2) -> {
      return a1.loc - a2.loc;
    });

    sum[0] = al.get(0).num;
    for (int i = 1; i < n; ++i) {
      sum[i] = sum[i - 1] + al.get(i).num;
    }

    int left = 0;
    int right = n - 1;
    long dist = Long.MAX_VALUE;
    while (left <= right) {
      int mid = (left + right) / 2;

      if (sum[mid] >= sum[n - 1] - sum[mid]) {
        right = mid - 1;
        dist = Math.min(dist, al.get(mid).loc);
      } else {
        left = mid + 1;
      }
    }

    bw.write(dist + "\n");
    bw.close();
  }

  public static class Pair {
    int loc;
    int num;

    public Pair(int loc, int num) {
      this.loc = loc;
      this.num = num;
    }
  }
}
```

출처 : [[Java] 백준 2141번 우체국](https://j3sung.tistory.com/m/1087)
