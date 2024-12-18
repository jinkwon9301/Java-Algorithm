# [level 2] 피로도 - 87946 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87946) 

### 성능 요약

메모리: 78.2 MB, 시간: 0.07 ms

### 구분

코딩테스트 연습 > 완전탐색

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 10월 5일 15:55:36

### 문제 설명

<p>XX게임에는 피로도 시스템(0 이상의 정수로 표현합니다)이 있으며, 일정 피로도를 사용해서 던전을 탐험할 수 있습니다. 이때, 각 던전마다 탐험을 시작하기 위해 필요한 "최소 필요 피로도"와 던전 탐험을 마쳤을 때 소모되는 "소모 피로도"가 있습니다. "최소 필요 피로도"는 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도를 나타내며, "소모 피로도"는 던전을 탐험한 후 소모되는 피로도를 나타냅니다. 예를 들어 "최소 필요 피로도"가 80, "소모 피로도"가 20인 던전을 탐험하기 위해서는 유저의 현재 남은 피로도는 80 이상 이어야 하며, 던전을 탐험한 후에는 피로도 20이 소모됩니다.</p>

<p>이 게임에는 하루에 한 번씩 탐험할 수 있는 던전이 여러개 있는데, 한 유저가 오늘 이 던전들을 최대한 많이 탐험하려 합니다. 유저의 현재 피로도 k와 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열 dungeons 가 매개변수로 주어질 때, 유저가 탐험할수 있는 최대 던전 수를 return 하도록 solution 함수를 완성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>k는 1 이상 5,000 이하인 자연수입니다.</li>
<li>dungeons의 세로(행) 길이(즉, 던전의 개수)는 1 이상 8 이하입니다.

<ul>
<li>dungeons의 가로(열) 길이는 2 입니다.</li>
<li>dungeons의 각 행은 각 던전의 ["최소 필요 피로도", "소모 피로도"] 입니다.</li>
<li>"최소 필요 피로도"는 항상 "소모 피로도"보다 크거나 같습니다.</li>
<li>"최소 필요 피로도"와 "소모 피로도"는 1 이상 1,000 이하인 자연수입니다.</li>
<li>서로 다른 던전의 ["최소 필요 피로도", "소모 피로도"]가 서로 같을 수 있습니다. </li>
</ul></li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>k</th>
<th>dungeons</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>80</td>
<td>[[80,20],[50,40],[30,10]]</td>
<td>3</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>현재 피로도는 80입니다.</p>

<p>만약, 첫 번째 → 두 번째 → 세 번째 던전 순서로 탐험한다면</p>

<ul>
<li>현재 피로도는 80이며, 첫 번째 던전을 돌기위해 필요한 "최소 필요 피로도" 또한 80이므로, 첫 번째 던전을 탐험할 수 있습니다. 첫 번째 던전의 "소모 피로도"는 20이므로, 던전을 탐험한 후 남은 피로도는 60입니다.</li>
<li>남은 피로도는 60이며, 두 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 50이므로, 두 번째 던전을 탐험할 수 있습니다. 두 번째 던전의 "소모 피로도"는 40이므로, 던전을 탐험한 후 남은 피로도는 20입니다.</li>
<li>남은 피로도는 20이며, 세 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 30입니다. 따라서 세 번째 던전은 탐험할 수 없습니다.</li>
</ul>

<p>만약, 첫 번째 → 세 번째 → 두 번째 던전 순서로 탐험한다면</p>

<ul>
<li>현재 피로도는 80이며, 첫 번째 던전을 돌기위해 필요한 "최소 필요 피로도" 또한 80이므로, 첫 번째 던전을 탐험할 수 있습니다. 첫 번째 던전의 "소모 피로도"는 20이므로, 던전을 탐험한 후 남은 피로도는 60입니다.</li>
<li>남은 피로도는 60이며, 세 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 30이므로, 세 번째 던전을 탐험할 수 있습니다. 세 번째 던전의 "소모 피로도"는 10이므로, 던전을 탐험한 후 남은 피로도는 50입니다.</li>
<li>남은 피로도는 50이며, 두 번째 던전을 돌기위해 필요한 "최소 필요 피로도"는 50이므로, 두 번째 던전을 탐험할 수 있습니다. 두 번째 던전의 "소모 피로도"는 40이므로, 던전을 탐험한 후 남은 피로도는 10입니다.</li>
</ul>

<p>따라서 이 경우 세 던전을 모두 탐험할 수 있으며, 유저가 탐험할 수 있는 최대 던전 수는 3입니다.</p>

<hr>

<p>※ 공지 - 2022년 2월 25일 테스트케이스가 추가되었습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges

---

문제
백트래킹에 익숙하다면, 그렇게까지 어려운 문제가 아니다.

문제 자체는 이해가 어렵지 않으니 바로 넘어가도록 한다.

알고리즘
점화식(재귀함수)
이 문제에서의 한 던전은 DFS의 한 노드와 같다.

즉, dungeons를 선회하면서

이미 방문한 던전(노드) 인지를 확인한다.

boolean 타입 배열 visited를 이용한다.
만약 방문한 던전(노드)라면, 다음 노드로 넘어간다.
각 던전의 필요 피로도와 현재 피로도를 비교하며 던전을 탐험할 수 있는지 판단한다.

방문한 적이 없고, 현재 피로도가 필요 피로도보다 높다면 점화식을 수행하게 된다.

해당 던전을 방문한 것으로 처리한다.
1 증가한 depth와 현재 피로도에서 해당 던전의 소모 피로도만큼 감소한 상태로 다음 재귀를 돌게 된다.
해당 던전을 방문하지 않은 것으로 처리한다.
종료 조건
이 문제의 경우엔 따로 점화식의 종료 조건이 없다. 즉, 모든 경우의 수를 순회한다는 의미이다.

전역변수화 고려하기
DFS문제의 경우 변화하지 않는 변수를 사용하여 재귀함수의 파라미터를 줄일 수 있다.

이 문제의 경우엔 dungeons 배열은 변화하지 않으므로, 전역 변수로 이차원 int 배열을 생성하고, dungeons로 초기화하여 사용한다면, 인자 하나를 적게 넘겨줄 수 있다.

다른 DFS 문제들의 경우엔 특정 depth에 도달하는 경우의 수를 구하는 등의 경우가 있다. 전역 변수로 선언하여 간결한 코드로 구현할 수 있다.

코드

```java
class Solution {  
    static boolean[] visited;  
    static int count = 0;  
  
    public int solution(int k, int[][] dungeons) {  
        visited = new boolean[dungeons.length];  
        dfs(0, k, dungeons);  
        return count;  
    }  
      
    private void dfs(int depth, int fatigue, int[][] dungeons){  
        for (int i = 0; i < dungeons.length; i++){  
            if (visited[i] || dungeons[i][0] > fatigue) {  
                continue;  
            }  
            visited[i] = true;  
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);  
            visited[i] = false;  
        }  
        count = Math.max(count, depth);  
    }  
}
```
재귀 함수 내에서 depth +1 을 인자로 보내게 되는데, 이때 depth++을 사용했다면, dfs 재귀 호출 다음 줄에서 depth--하지 않으면 틀린다.

depth++, depth--의 경우 depth 변수 자체의 값을 변화시킨채 유지 되기 때문이다.

출처 : [[프로그래머스] 피로도 - JAVA [자바]](https://velog.io/@doxxx93/practice-kit-brute-force-2)

```java
// 24/1/3 (수) 복습
// dfs 문제
// 백트래킹?

import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int count = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        
        return count;
    }
    
    static void dfs(int depth, int fatigue, int[][] dungeons) {
        // 방문할 던전들을 순회한다.
        for (int i = 0; i < dungeons.length; i++) {
            // 만약 던전을 방문했거나 필요피로도가 남은 피로도보다 크다면 무시하고 다음 던전을 탐색한다.
            if (visited[i] || fatigue < dungeons[i][0]) {
                continue;
            }
            
            // 해당 던전을 방문한다.
            visited[i] = true;
            // 다음으로 방문할 던전들을 순회하기 위해 재귀함수 실행
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
            // 던전 방문을 취소한다.
            visited[i] = false;
        }
        
        // 최대 방문횟수를 저장한다.
        count = Math.max(count, depth);
    }
}
```
<img width="747" alt="Screenshot 2024-11-24 at 5 42 55 PM" src="https://github.com/user-attachments/assets/fad56f3d-40e5-4321-9a75-c5a07dc15dd4">

- 이때, 한 번에 탐색할 수 있는 DFS의 끝단까지 탐색을 완료한 후 다시 이전 단계로 돌아가는 작업을 해줘야한다.
- 이 과정에서 이전노드로 돌아갈 때, 방문 여부(check 배열)와 방문 횟수(cnt)를 이전 노드까지 탐색했을 때의 값으로 복구해줘야 한다.
- answer를 전역 변수로 선언한다. answer(최종 탐험 횟수)를 전역변수로 선언하여 DFS 함수 내에서 계속 갱신되는 cnt 값과 비교하고, cnt값이 answer보다 큰 경우 answer를 해당 cnt 값으로 새롭게 갱신한다.

```java
        answer = 0
        def DFS(k, cnt, dungeons, check):
            global answer
            answer = max(answer, cnt)
            for i in range(len(dungeons)):
                if check[i] == 0 and k >= dungeons[i][0]:       # 방문하지 않은 던전이고, 현재 피로도가 해당 던전을 방문하기 위한 최소 피로도보다 크면
                    check[i] = 1
                    # ** 중요 **
                    # 이전 노드로 다시 back할 때, check 값만 0으로 바꿔줄 뿐 아니라 
                    # 현재 피로도의 수도 해당 노드를 방문하기 전의 피로도로 다시 복구해줘야 한다. 
                    # 따라서, 직접적으로 k 값과 cnt 값을 바꿔주기 보다는, DFS 함수 내에서 보내주는 매개변수의 값을 수정해줘야 한다.
                    DFS(k-dungeons[i][1], cnt+1, dungeons, check)
                    check[i] = 0
            
        
        def solution(k, dungeons):
            # answer = 0
            global answer
            check = [0]*len(dungeons)       # 방문 여부 체크하는 배열
            
            # cnt: 탐험한 던전 개수, k: 남은 피로도
            DFS(k, 0, dungeons, check)     # 0: 방문한 던전의 개수를 0으로 DFS 함수에 넘겨준다.
            
            return answer
```
**💡 핵심 포인트**
- 위 부분에서 중요한 점은 백트래킹을 할 때는 DFS의 끝단까지 탐색 후 이전노드로 돌아갈 때, 방문 여부(check 배열)와 방문 횟수(cnt)를 이전 노드까지 탐색했을 때의 값으로 복구해줘야 한다는 것이다.
- 위 생각을 하는 것이 굉장히!! 중요하다.
- 처음에는 위 생각을 하지 않고 풀었다가 오류가 발생했다.

---

출처 : https://velog.io/@soorim_yoon/DFS%EC%99%84%EC%A0%84%ED%83%90%EC%83%89-%ED%94%BC%EB%A1%9C%EB%8F%84-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level2
