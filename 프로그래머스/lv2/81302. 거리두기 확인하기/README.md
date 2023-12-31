# [level 2] 거리두기 확인하기 - 81302 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/81302) 

### 성능 요약

메모리: 76.1 MB, 시간: 0.08 ms

### 구분

코딩테스트 연습 > 2021 카카오 채용연계형 인턴십

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 문제 설명

<p>개발자를 희망하는 죠르디가 카카오에 면접을 보러 왔습니다.<br><br>
코로나 바이러스 감염 예방을 위해 응시자들은 거리를 둬서 대기를 해야하는데 개발 직군 면접인 만큼<br>
아래와 같은 규칙으로 대기실에 거리를 두고 앉도록 안내하고 있습니다.</p>

<blockquote>
<ol>
<li>대기실은 5개이며, 각 대기실은 5x5 크기입니다.</li>
<li>거리두기를 위하여 응시자들 끼리는 맨해튼 거리<sup id="fnref1"><a href="#fn1">1</a></sup>가 2 이하로 앉지 말아 주세요.</li>
<li>단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우에는 허용합니다.</li>
</ol>
</blockquote>

<p>예를 들어, </p>
<table class="table">
        <thead><tr>
<th style="text-align: center"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/8c056cac-ec8f-435c-a49a-8125df055c5e/PXP.png" title="" alt="PXP.png"></th>
<th style="text-align: center"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/d611f66e-f9c4-4433-91ce-02887657fe7f/PX_XP.png" title="" alt="PX_XP.png"></th>
<th style="text-align: center"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/ed707158-0511-457b-9e1a-7dbf34a776a5/PX_OP.png" title="" alt="PX_OP.png"></th>
</tr>
</thead>
        <tbody><tr>
<td style="text-align: center">위 그림처럼 자리 사이에 파티션이 존재한다면 맨해튼 거리가 2여도 거리두기를 <strong>지킨 것입니다.</strong></td>
<td style="text-align: center">위 그림처럼 파티션을 사이에 두고 앉은 경우도 거리두기를 <strong>지킨 것입니다.</strong></td>
<td style="text-align: center">위 그림처럼 자리 사이가 맨해튼 거리 2이고 사이에 빈 테이블이 있는 경우는 거리두기를 <strong>지키지 않은 것입니다.</strong></td>
</tr>
<tr>
<td style="text-align: center"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/4c548421-1c32-4947-af9e-a45c61501bc4/P.png" title="" alt="P.png"></td>
<td style="text-align: center"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/ce799a38-668a-4038-b32f-c515b8701262/O.png" title="" alt="O.png"></td>
<td style="text-align: center"><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/91e8f98b-baeb-4f81-8cb6-5bafebebdcc7/X.png" title="" alt="X.png"></td>
</tr>
<tr>
<td style="text-align: center">응시자가 앉아있는 자리(<code>P</code>)를 의미합니다.</td>
<td style="text-align: center">빈 테이블(<code>O</code>)을 의미합니다.</td>
<td style="text-align: center">파티션(<code>X</code>)을 의미합니다.</td>
</tr>
</tbody>
      </table>
<p>5개의 대기실을 본 죠르디는 각 대기실에서 응시자들이 거리두기를 잘 기키고 있는지 알고 싶어졌습니다. 자리에 앉아있는 응시자들의 정보와 대기실 구조를 대기실별로 담은 2차원 문자열 배열 <code>places</code>가 매개변수로 주어집니다. 각 대기실별로 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 배열에 담아 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li><code>places</code>의 행 길이(대기실 개수) = 5

<ul>
<li><code>places</code>의 각 행은 하나의 대기실 구조를 나타냅니다.</li>
</ul></li>
<li><code>places</code>의 열 길이(대기실 세로 길이) = 5</li>
<li><code>places</code>의 원소는 <code>P</code>,<code>O</code>,<code>X</code>로 이루어진 문자열입니다.

<ul>
<li><code>places</code> 원소의 길이(대기실 가로 길이) = 5</li>
<li><code>P</code>는 응시자가 앉아있는 자리를 의미합니다.</li>
<li><code>O</code>는 빈 테이블을 의미합니다.</li>
<li><code>X</code>는 파티션을 의미합니다.</li>
</ul></li>
<li>입력으로 주어지는 5개 대기실의 크기는 모두 5x5 입니다.</li>
<li>return 값 형식

<ul>
<li>1차원 정수 배열에 5개의 원소를 담아서 return 합니다.</li>
<li><code>places</code>에 담겨 있는 5개 대기실의 순서대로, 거리두기 준수 여부를 차례대로 배열에 담습니다.</li>
<li>각 대기실 별로 모든 응시자가 거리두기를 지키고 있으면 1을, 한 명이라도 지키지 않고 있으면 0을 담습니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>places</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td><code>[["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]</code></td>
<td>[1, 0, 1, 1, 1]</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>첫 번째 대기실</p>
<table class="table">
        <thead><tr>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>
</thead>
        <tbody><tr>
<td>No.</td>
<td>0</td>
<td>1</td>
<td>2</td>
<td>3</td>
<td>4</td>
</tr>
<tr>
<td>0</td>
<td>P</td>
<td>O</td>
<td>O</td>
<td>O</td>
<td>P</td>
</tr>
<tr>
<td>1</td>
<td>O</td>
<td>X</td>
<td>X</td>
<td>O</td>
<td>X</td>
</tr>
<tr>
<td>2</td>
<td>O</td>
<td>P</td>
<td>X</td>
<td>P</td>
<td>X</td>
</tr>
<tr>
<td>3</td>
<td>O</td>
<td>O</td>
<td>X</td>
<td>O</td>
<td>X</td>
</tr>
<tr>
<td>4</td>
<td>P</td>
<td>O</td>
<td>X</td>
<td>X</td>
<td>P</td>
</tr>
</tbody>
      </table>
<ul>
<li>모든 응시자가 거리두기를 지키고 있습니다.</li>
</ul>

<p>두 번째 대기실</p>
<table class="table">
        <thead><tr>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>
</thead>
        <tbody><tr>
<td>No.</td>
<td>0</td>
<td>1</td>
<td>2</td>
<td>3</td>
<td>4</td>
</tr>
<tr>
<td>0</td>
<td><strong>P</strong></td>
<td>O</td>
<td>O</td>
<td><strong>P</strong></td>
<td>X</td>
</tr>
<tr>
<td>1</td>
<td>O</td>
<td>X</td>
<td><strong>P</strong></td>
<td>X</td>
<td>P</td>
</tr>
<tr>
<td>2</td>
<td><strong>P</strong></td>
<td>X</td>
<td>X</td>
<td>X</td>
<td>O</td>
</tr>
<tr>
<td>3</td>
<td>O</td>
<td>X</td>
<td>X</td>
<td>X</td>
<td>O</td>
</tr>
<tr>
<td>4</td>
<td>O</td>
<td>O</td>
<td>O</td>
<td><strong>P</strong></td>
<td><strong>P</strong></td>
</tr>
</tbody>
      </table>
<ul>
<li>(0, 0) 자리의 응시자와 (2, 0) 자리의 응시자가 거리두기를 지키고 있지 않습니다.</li>
<li>(1, 2) 자리의 응시자와 (0, 3) 자리의 응시자가 거리두기를 지키고 있지 않습니다.</li>
<li>(4, 3) 자리의 응시자와 (4, 4) 자리의 응시자가 거리두기를 지키고 있지 않습니다.</li>
</ul>

<p>세 번째 대기실</p>
<table class="table">
        <thead><tr>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>
</thead>
        <tbody><tr>
<td>No.</td>
<td>0</td>
<td>1</td>
<td>2</td>
<td>3</td>
<td>4</td>
</tr>
<tr>
<td>0</td>
<td>P</td>
<td>X</td>
<td>O</td>
<td>P</td>
<td>X</td>
</tr>
<tr>
<td>1</td>
<td>O</td>
<td>X</td>
<td>O</td>
<td>X</td>
<td>P</td>
</tr>
<tr>
<td>2</td>
<td>O</td>
<td>X</td>
<td>P</td>
<td>O</td>
<td>X</td>
</tr>
<tr>
<td>3</td>
<td>O</td>
<td>X</td>
<td>X</td>
<td>O</td>
<td>P</td>
</tr>
<tr>
<td>4</td>
<td>P</td>
<td>X</td>
<td>P</td>
<td>O</td>
<td>X</td>
</tr>
</tbody>
      </table>
<ul>
<li>모든 응시자가 거리두기를 지키고 있습니다.</li>
</ul>

<p>네 번째 대기실</p>
<table class="table">
        <thead><tr>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>
</thead>
        <tbody><tr>
<td>No.</td>
<td>0</td>
<td>1</td>
<td>2</td>
<td>3</td>
<td>4</td>
</tr>
<tr>
<td>0</td>
<td>O</td>
<td>O</td>
<td>O</td>
<td>X</td>
<td>X</td>
</tr>
<tr>
<td>1</td>
<td>X</td>
<td>O</td>
<td>O</td>
<td>O</td>
<td>X</td>
</tr>
<tr>
<td>2</td>
<td>O</td>
<td>O</td>
<td>O</td>
<td>X</td>
<td>X</td>
</tr>
<tr>
<td>3</td>
<td>O</td>
<td>X</td>
<td>O</td>
<td>O</td>
<td>X</td>
</tr>
<tr>
<td>4</td>
<td>O</td>
<td>O</td>
<td>O</td>
<td>O</td>
<td>O</td>
</tr>
</tbody>
      </table>
<ul>
<li>대기실에 응시자가 없으므로 거리두기를 지키고 있습니다.</li>
</ul>

<p>다섯 번째 대기실</p>
<table class="table">
        <thead><tr>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
<th></th>
</tr>
</thead>
        <tbody><tr>
<td>No.</td>
<td>0</td>
<td>1</td>
<td>2</td>
<td>3</td>
<td>4</td>
</tr>
<tr>
<td>0</td>
<td>P</td>
<td>X</td>
<td>P</td>
<td>X</td>
<td>P</td>
</tr>
<tr>
<td>1</td>
<td>X</td>
<td>P</td>
<td>X</td>
<td>P</td>
<td>X</td>
</tr>
<tr>
<td>2</td>
<td>P</td>
<td>X</td>
<td>P</td>
<td>X</td>
<td>P</td>
</tr>
<tr>
<td>3</td>
<td>X</td>
<td>P</td>
<td>X</td>
<td>P</td>
<td>X</td>
</tr>
<tr>
<td>4</td>
<td>P</td>
<td>X</td>
<td>P</td>
<td>X</td>
<td>P</td>
</tr>
</tbody>
      </table>
<ul>
<li>모든 응시자가 거리두기를 지키고 있습니다.</li>
</ul>

<p>두 번째 대기실을 제외한 모든 대기실에서 거리두기가 지켜지고 있으므로, 배열 [1, 0, 1, 1, 1]을 return 합니다.</p>

<hr>

<h5>제한시간 안내</h5>

<ul>
<li>정확성 테스트 : 10초</li>
</ul>

<p>※ 공지 - 2022년 4월 25일 테스트케이스가 추가되었습니다.</p>

<div class="footnotes">
<hr>
<ol>

<li id="fn1">
<p>두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다.&nbsp;<a href="#fnref1">↩</a></p>
</li>

</ol>
</div>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges

---

문제를 읽고 전형적인 DFS / BFS 문제라고 생각했다.

다만 DFS / BFS를 구현하는 부분이 조금 막혔다.

그래서 모든 경우의 수를 나누어 먼저 풀어보았고

BFS를 이용해서 다시 풀어 보았다.

 
모든 경우의 수를 나눈 방법은 BFS를 이용했을 때보다 시간이 훨씬 적게 걸렸다.

다만 코드의 길이가 좀 길고 거리가 2인 확인과 대각선 확인의 로직이 복잡해

장단점이 있는 것 같다.


최종 코드 (모든 경우)
```java
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < places.length; i++) {
            String[] temp = places[i];
            boolean check = false;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (temp[j].charAt(k) == 'P') {
                        if(search(j, k, temp)) {
                            check = true;
                        }
                    }
                }
            }
            answer[i] = check ? 0 : 1;
        }
        return answer;
    }
        static boolean search(int x, int y, String[] temp) {
        // 상하좌우 확인
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                continue;
            }
            if (temp[nx].charAt(ny) == 'P') {
                return true;
            }
        }

        // 거리 2인 경우 확인
        int[] dx2 = {0, 0, 2, -2};
        int[] dy2 = {2, -2, 0, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx2[i];
            int ny = y + dy2[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                continue;
            }
            if (temp[nx].charAt(ny) == 'P') {
                // 둘 사이에 X가 없다면
                if (temp[x + dx2[i] / 2].charAt(y + dy2[i] / 2) != 'X') {
                    return true;
                }
            }
        }

        // 대각선 확인
        int[] dx3 = {1, 1, -1, -1};
        int[] dy3 = {1, -1, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx3[i];
            int ny = y + dy3[i];
            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                continue;
            }
            if (temp[nx].charAt(ny) == 'P') {
                // p위치에 맞는 상하좌우에 X가 없다면
                if (!(temp[x].charAt(ny) == 'X' && temp[nx].charAt(y) == 'X')) {
                    return true;
                }
            }
        }
        return false;
    }
}
```

최종 코드 (BFS)
```java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < places.length; i++) {
            String[] temp = places[i];
            boolean check = false;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (temp[j].charAt(k) == 'P') {
                        if(bfs(j, k, temp)) {
                            check = true;
                        }
                    }
                }
            }
            answer[i] = check ? 0 : 1;
        }
        return answer;
    }
    static boolean bfs(int x, int y, String[] p) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                // 탐색 범위를 벗어나면 + 최초 출발점을 탐색에서 제외
                if ((nx < 0 || ny < 0 || nx >= 5 || ny >= 5) || (nx == x && ny == y)) {
                    continue;
                }

                // 맨해튼 거리 구하기
                int m = Math.abs(x - nx) + Math.abs(y - ny);

                // p가 맨해튼 거리 안에 있다면
                if (p[nx].charAt(ny) == 'P' && m <= 2) {
                    return true;
                    // O를 발견하면 O를 중심으로 다시 탐색
                } else if (p[nx].charAt(ny) == 'O' && m < 2) {
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
```

출처 : [(Java) 프로그래머스 거리두기 확인하기](https://rovictory.tistory.com/101)

---

📝 결론
해당 문제는 DFS를 사용하여 아래와 같은 방법으로 탐색을 진행하면 쉽게 풀이가 가능하다.

벽으로 막혀있으면 해당 root는 탐색을 중단
사람이 있으면 거리두기 실패
책상이 있을 경우 depth가 2보다 작을 경우 계속 탐색
DFS를 활용할 수 있는 사람이라면 쉽게 풀이할 수 있는 문제였습니다!!

👨🏻‍💻 작성한 코드
```java
class Solution {
    static int[] dx = {-1, 1, 0, 0}, dy ={0, 0, -1, 1};
    static char[][] matrix;
    static boolean[][] check;
    static boolean isAvailable;
    
    static int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i=0; i<5; i++) {
            isAvailable = false;
            matrix = new char[5][5];
            // matrix에 값 추가
            for (int j=0; j<5; j++) {
                matrix[j] = places[i][j].toCharArray();
            }
   
            
            // matrix에 사람이 있는 곳들을 검사
            for (int r=0; r<5; r++) {
                for (int c=0; c<5; c++) {
                	if (matrix[r][c] == 'P') {
                		check = new boolean[5][5];
	                    dfs(0, r, c);
	                    if (isAvailable) {
	                    	break;  	
	                    }
                	}
                }
                if (isAvailable) break;
            }
            if (isAvailable) answer[i] = 0;
            else answer[i] = 1;
        }
        
        return answer;
        
        
    }
    
    static void dfs(int currentDepth, int r, int c) {
        if (currentDepth >= 2) return;
        check[r][c] = true;
        for (int i=0; i<4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            
            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || check[nr][nc]) continue;
            
            
            // 테이블이 있을 경우
            if (matrix[nr][nc] == 'O') dfs(currentDepth+1, nr, nc);
            
            // 사람이 있을 경우 거리두기 실패
            else if (matrix[nr][nc] == 'P') {
                isAvailable = true;
                return;
            }
            // 벽이 있는 경우
            else if (matrix[nr][nc] == 'X') {
                continue;
            }
 
        }
    }

}
```

출처 : [[프로그래머스] 거리두기 확인하기 (Java)](https://velog.io/@seongwon97/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B1%B0%EB%A6%AC%EB%91%90%EA%B8%B0-%ED%99%95%EC%9D%B8%ED%95%98%EA%B8%B0-Java)

---

```java
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;

    static int[] answer;

    public void dfs(int num, int x, int y, int count, String[] places){
        if (count > 2) return;
        if (count > 0 && count <= 2 && places[x].charAt(y) == 'P'){
            //2칸 범위내에 다른 응시자가 있을 경우 거리두기 미준수로 0처리
            answer[num] = 0;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            //배열 범위 밖으로 초과하는지 여부 검사, 파티션으로 분리되어 있는 경우 상관 없음.
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && places[nx].charAt(ny) != 'X') {
                if (visit[nx][ny]) continue; //이미 방문한 곳일 경우 생략
                visit[nx][ny] = true;
                dfs(num, nx, ny, count + 1, places);
                visit[nx][ny] = false;
            }
        }
    }

    public int[] solution(String[][] places) {
        answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < places.length; i++) {
            visit = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P'){
                        visit[j][k] = true;
                        dfs(i, j, k, 0, places[i]);
                        visit[j][k] = false;
                    }
                }
            }
        }
        return answer;
    }
}
```

프로그래머스 최상단 코드 DFS


---

🔥 24.1.4 (목) 복습 : DFS

```java
class Solution {
  static private int[] answer;

  // 상하좌우 배열
  static private int[] dx = {1, -1, 0, 0};
  static private int[] dy = {0, 0, 1, -1};

  // 방문확인 배열
  static private boolean[][] visited;
    
  static private void dfs(int y, int x, int num, int depth, String[] place) {
    // depth가 3 이상이면 그냥 return;
    if (depth > 2) return;

    // depth가 0 이상이고 2 이하면서 현재 위치가 'P'이면 answer[num] = 0; 하고 return;
    if (0 < depth && depth <= 2 && place[y].charAt(x) == 'P') {
      answer[num] = 0;
      return;
    }

    // 상하좌우 이동하며 dfs 탐색한다.
    for (int i = 0; i < dx.length; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      // 방문할 곳이 범위를 벗어나거나 'X'인지 확인한다.
      if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && place[ny].charAt(nx) != 'X') {
        // 이미 방문한 곳일 경우 생략
        if (visited[ny][nx]) continue;
        visited[ny][nx] = true;
        dfs(ny, nx, num, depth + 1, place);
        visited[ny][nx] = false;
      }
    }
  }

  public int[] solution(String[][] places) {

    // answer를 담을 배열 필요함.
    answer = new int[places.length];
    // 미리 1을 담아두고 예외의 경우만 0으로 바꿔주도록 하자
    for (int i = 0; i < answer.length; i++) {
      answer[i] = 1;
    }

    for (int i = 0; i < places.length; i++) {
      // 방문배열 초기화
      visited = new boolean[5][5];

      for (int j = 0; j < places[i].length; j++) {
        for (int k = 0; k < places[i][j].length(); k++) {
          if (places[i][j].charAt(k) == 'P') {
            // 'P'면 방문한다.
            visited[j][k] = true;
            // dfs 탐색 시작
            dfs(j, k, i, 0, places[i]);
            // 방문 해제
            visited[j][k] = false;
          }
        }
      }
    }
    
    return answer;
  }
}
```
