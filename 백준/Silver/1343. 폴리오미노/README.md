# [Silver V] 폴리오미노 - 1343 

[문제 링크](https://www.acmicpc.net/problem/1343) 

### 성능 요약

메모리: 14308 KB, 시간: 120 ms

### 분류

그리디 알고리즘, 구현

### 제출 일자

2024년 1월 3일 14:25:12

### 문제 설명

<p>민식이는 다음과 같은 폴리오미노 2개를 무한개만큼 가지고 있다. AAAA와 BB</p>

<p>이제 '.'와 'X'로 이루어진 보드판이 주어졌을 때, 민식이는 겹침없이 'X'를 모두 폴리오미노로 덮으려고 한다. 이때, '.'는 폴리오미노로 덮으면 안 된다.</p>

<p>폴리오미노로 모두 덮은 보드판을 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 보드판이 주어진다. 보드판의 크기는 최대 50이다.</p>

### 출력 

 <p>첫째 줄에 사전순으로 가장 앞서는 답을 출력한다. 만약 덮을 수 없으면 -1을 출력한다.</p>


---

구현 방식을 요약하면
큰 문자열을 먼저 교체한 뒤, 나머지 문자열을 교체합니다.
이 때, 나머지 값을 비교하여 조건에 부합하는지 확인하는 작업을 하면 됩니다.
그리디 알고리즘을 입문하기에 좋은 문제라고 생각합니다.

```java
import java.util.*;
 
public class Main {
 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
 
        String res = "";
 
        res = poliomino(s);
 
        System.out.println(res);
    }
 
    private static String poliomino(String s) {
        String ans = "";
        String A = "AAAA", B = "BB";
        
        s = s.replaceAll("XXXX", A);
        ans = s.replaceAll("XX", B);
        
        if(ans.contains("X")) {
            ans = "-1";
        }
 
        return ans;
    }
}
```

> 출처 : [백준 1343 폴리오미노 (JAVA)](https://airzinc.tistory.com/entry/%EB%B0%B1%EC%A4%80-1343-JAVA)
