# [Silver IV] 로프 - 2217 

[문제 링크](https://www.acmicpc.net/problem/2217) 

### 성능 요약

메모리: 26564 KB, 시간: 404 ms

### 분류

그리디 알고리즘, 수학, 정렬

### 제출 일자

2024년 1월 4일 15:17:51

### 문제 설명

<p>N(1 ≤ N ≤ 100,000)개의 로프가 있다. 이 로프를 이용하여 이런 저런 물체를 들어올릴 수 있다. 각각의 로프는 그 굵기나 길이가 다르기 때문에 들 수 있는 물체의 중량이 서로 다를 수도 있다.</p>

<p>하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다. k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.</p>

<p>각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오. 모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다.</p>

### 입력 

 <p>첫째 줄에 정수 N이 주어진다. 다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다. 이 값은 10,000을 넘지 않는 자연수이다.</p>

### 출력 

 <p>첫째 줄에 답을 출력한다.</p>

---

그리디 알고리즘으로 접근해야 한다. 먼저 물체의 최대 중량을 구할 때 모든 로프를 사용해야 할 필요는 없다고 명시되어 있으니 무개를 견딜 수 있는 무게가 가장 큰 로프를 하나씩 선택하면서 물체의 최대중량을 갱신한다.

```java
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] =sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] * (i+1) > answer) answer = arr[i] * (i+1); //최소값 * 로프의수가 answer보다 크다면 갱신
        }


        System.out.println(answer);
    }

}
```

출처 : [백준 2217번 로프 (JAVA)](https://velog.io/@wken5577/%EB%B0%B1%EC%A4%80-2217%EB%B2%88-%EB%A1%9C%ED%94%84-JAVA)
