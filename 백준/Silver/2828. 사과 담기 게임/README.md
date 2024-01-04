# [Silver V] 사과 담기 게임 - 2828 

[문제 링크](https://www.acmicpc.net/problem/2828) 

### 성능 요약

메모리: 14172 KB, 시간: 124 ms

### 분류

그리디 알고리즘, 구현

### 제출 일자

2024년 1월 4일 14:13:51

### 문제 설명

<p>상근이는 오락실에서 바구니를 옮기는 오래된 게임을 한다. 스크린은 N칸으로 나누어져 있다. 스크린의 아래쪽에는 M칸을 차지하는 바구니가 있다. (M<N) 플레이어는 게임을 하는 중에 바구니를 왼쪽이나 오른쪽으로 이동할 수 있다. 하지만, 바구니는 스크린의 경계를 넘어가면 안 된다. 가장 처음에 바구니는 왼쪽 M칸을 차지하고 있다.</p>

<p>스크린의 위에서 사과 여러 개가 떨어진다. 각 사과는 N칸중 한 칸의 상단에서 떨어지기 시작하며, 스크린의 바닥에 닿을때까지 직선으로 떨어진다. 한 사과가 바닥에 닿는 즉시, 다른 사과가 떨어지기 시작한다.</p>

<p>바구니가 사과가 떨어지는 칸을 차지하고 있다면, 바구니는 그 사과가 바닥에 닿을 때, 사과를 담을 수 있다. 상근이는 사과를 모두 담으려고 한다. 이때, 바구니의 이동 거리의 최솟값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N과 M이 주어진다. (1 ≤ M < N ≤ 10) 둘째 줄에 떨어지는 사과의 개수 J가 주어진다. (1 ≤ J ≤ 20) 다음 J개 줄에는 사과가 떨어지는 위치가 순서대로 주어진다.</p>

### 출력 

 <p>모든 사과를 담기 위해서 바구니가 이동해야 하는 거리의 최솟값을 출력한다.</p>

---

```java
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int answer = 0;	//이동 횟수 저장 변수
        int start = 1, end = M;	//바구니 시작, 끝의 위치
        //사과 바구니에 담기 탐색!
        for(int i=0;i<j;i++){
            int apple = Integer.parseInt(br.readLine());
            if(start > apple){		//시작 위치 > 사과 위치
                answer += start - apple;	//이동한 거리 더하기
                end -= start - apple;	//끝 위치 변경
                start = apple;		//시작 위치 변경
            }else if(end < apple){	//끝 위치 < 사과 위치
                answer += apple - end;	//이동한 거리 더하기
                start += apple - end;	//시작 위치 변경
                end = apple;	//끝 위치 변경
            }
        }
        bw.write(answer + "");		//이동 거리 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}
```

```java
  end -= start - apple;	//끝 위치 변경
  start = apple;		//시작 위치 변경
```
- 순서가 중요하다. `start = apple` 먼저 하게 되면 `start` 조정된 `start` 변수 값이 대입되게 된다.

출처 : [[백준] 알고리즘 분류(그리디 알고리즘,JAVA)2828번, 사과 담기 게임](https://tussle.tistory.com/941)
