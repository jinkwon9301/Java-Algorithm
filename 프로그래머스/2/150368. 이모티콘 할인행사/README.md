# [level 2] 이모티콘 할인행사 - 150368 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/150368) 

### 성능 요약

메모리: 100 MB, 시간: 60.22 ms

### 구분

코딩테스트 연습 > 2023 KAKAO BLIND RECRUITMENT

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 04월 04일 14:56:23

### 문제 설명

<p>카카오톡에서는 이모티콘을 무제한으로 사용할 수 있는 이모티콘 플러스 서비스 가입자 수를 늘리려고 합니다.<br>
이를 위해 카카오톡에서는 이모티콘 할인 행사를 하는데, 목표는 다음과 같습니다.</p>

<ol>
<li>이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.</li>
<li>이모티콘 판매액을 최대한 늘리는 것.</li>
</ol>

<p><strong><u>1번 목표가 우선이며, 2번 목표가 그 다음입니다.</u></strong></p>

<p>이모티콘 할인 행사는 다음과 같은 방식으로 진행됩니다.</p>

<ul>
<li><code>n</code>명의 카카오톡 사용자들에게 이모티콘 <code>m</code>개를 할인하여 판매합니다.</li>
<li>이모티콘마다 할인율은 다를 수 있으며, 할인율은 10%, 20%, 30%, 40% 중 하나로 설정됩니다.</li>
</ul>

<p>카카오톡 사용자들은 다음과 같은 기준을 따라 이모티콘을 사거나, 이모티콘 플러스 서비스에 가입합니다.</p>

<ul>
<li>각 사용자들은 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘을 모두 구매합니다.</li>
<li>각 사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.</li>
</ul>

<p>다음은 2명의 카카오톡 사용자와 2개의 이모티콘이 있을때의 예시입니다.</p>
<table class="table">
        <thead><tr>
<th>사용자</th>
<th>비율</th>
<th>가격</th>
</tr>
</thead>
        <tbody><tr>
<td>1</td>
<td>40</td>
<td>10,000</td>
</tr>
<tr>
<td>2</td>
<td>25</td>
<td>10,000</td>
</tr>
</tbody>
      </table><table class="table">
        <thead><tr>
<th>이모티콘</th>
<th>가격</th>
</tr>
</thead>
        <tbody><tr>
<td>1</td>
<td>7,000</td>
</tr>
<tr>
<td>2</td>
<td>9,000</td>
</tr>
</tbody>
      </table>
<p>1번 사용자는 40%이상 할인하는 이모티콘을 모두 구매하고, 이모티콘 구매 비용이 10,000원 이상이 되면 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.<br>
2번 사용자는 25%이상 할인하는 이모티콘을 모두 구매하고, 이모티콘 구매 비용이 10,000원 이상이 되면 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.</p>

<p>1번 이모티콘의 가격은 7,000원, 2번 이모티콘의 가격은 9,000원입니다.</p>

<p>만약, 2개의 이모티콘을 모두 40%씩 할인한다면, 1번 사용자와 2번 사용자 모두 1,2번 이모티콘을 구매하게 되고, 결과는 다음과 같습니다.</p>
<table class="table">
        <thead><tr>
<th>사용자</th>
<th>구매한 이모티콘</th>
<th>이모티콘 구매 비용</th>
<th>이모티콘 플러스 서비스 가입 여부</th>
</tr>
</thead>
        <tbody><tr>
<td>1</td>
<td>1, 2</td>
<td>9,600</td>
<td>X</td>
</tr>
<tr>
<td>2</td>
<td>1, 2</td>
<td>9,600</td>
<td>X</td>
</tr>
</tbody>
      </table>
<p>이모티콘 플러스 서비스 가입자는 0명이 늘어나고 이모티콘 판매액은 19,200원이 늘어납니다.</p>

<p>하지만, 1번 이모티콘을 30% 할인하고 2번 이모티콘을 40% 할인한다면 결과는 다음과 같습니다.</p>
<table class="table">
        <thead><tr>
<th>사용자</th>
<th>구매한 이모티콘</th>
<th>이모티콘 구매 비용</th>
<th>이모티콘 플러스 서비스 가입 여부</th>
</tr>
</thead>
        <tbody><tr>
<td>1</td>
<td>2</td>
<td>5,400</td>
<td>X</td>
</tr>
<tr>
<td>2</td>
<td>1, 2</td>
<td>10,300</td>
<td>O</td>
</tr>
</tbody>
      </table>
<p>2번 사용자는 이모티콘 구매 비용을 10,000원 이상 사용하여 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입하게 됩니다.<br>
따라서, 이모티콘 플러스 서비스 가입자는 1명이 늘어나고 이모티콘 판매액은 5,400원이 늘어나게 됩니다.</p>

<p>카카오톡 사용자 <code>n</code>명의 구매 기준을 담은 2차원 정수 배열 <code>users</code>, 이모티콘 <code>m</code>개의 정가를 담은 1차원 정수 배열 <code>emoticons</code>가 주어집니다. 이때, 행사 목적을 최대한으로 달성했을 때의 이모티콘 플러스 서비스 가입 수와 이모티콘 매출액을 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>users</code>의 길이 = <code>n</code> ≤ 100

<ul>
<li><code>users</code>의 원소는 [<code>비율</code>, <code>가격</code>]의 형태입니다.</li>
<li><code>users[i]</code>는 <code>i+1</code>번 고객의 구매 기준을 의미합니다.</li>
<li><code>비율</code>% 이상의 할인이 있는 이모티콘을 모두 구매한다는 의미입니다.

<ul>
<li>1 ≤ <code>비율</code> ≤ 40</li>
</ul></li>
<li><code>가격</code>이상의 돈을 이모티콘 구매에 사용한다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입한다는 의미입니다.

<ul>
<li>100 ≤ <code>가격</code> ≤ 1,000,000</li>
<li><code>가격</code>은 100의 배수입니다.</li>
</ul></li>
</ul></li>
<li>1 ≤ <code>emoticons</code>의 길이 = <code>m</code> ≤ 7

<ul>
<li><code>emoticons[i]</code>는 <code>i+1</code>번 이모티콘의 정가를 의미합니다.</li>
<li>100 ≤ <code>emoticons</code>의 원소 ≤ 1,000,000</li>
<li><code>emoticons</code>의 원소는 100의 배수입니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>users</th>
<th>emoticons</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[[40, 10000], [25, 10000]]</td>
<td>[7000, 9000]</td>
<td>[1, 5400]</td>
</tr>
<tr>
<td>[[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]]</td>
<td>[1300, 1500, 1600, 4900]</td>
<td>[4, 13860]</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제의 예시와 같습니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>다음과 같이 할인하는 것이 이모티콘 플러스 서비스 가입자를 최대한 늘리면서, 이모티콘 판매액 또한 최대로 늘리는 방법입니다.</p>
<table class="table">
        <thead><tr>
<th>이모티콘</th>
<th>할인율</th>
</tr>
</thead>
        <tbody><tr>
<td>1</td>
<td>40</td>
</tr>
<tr>
<td>2</td>
<td>40</td>
</tr>
<tr>
<td>3</td>
<td>20</td>
</tr>
<tr>
<td>4</td>
<td>40</td>
</tr>
</tbody>
      </table>
<p>위와 같이 할인하면 4명의 이모티콘 플러스 가입자와 13,860원의 판매액을 달성할 수 있습니다. 다른 할인율을 적용하여 이모티콘을 판매할 수 있지만 이보다 이모티콘 플러스 서비스 가입자를 최대한 늘리면서, 이모티콘 판매액 또한 최대로 늘리는 방법은 없습니다.<br>
따라서, [4, 13860]을 return 하면 됩니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges

***
📝 code
```java
/*
  [프로그래머스] 이모티콘 할인행사

  user는 자신이 설정한 할인율 이상인 이모티콘을 구매한다.
  이모티콘을 구매한 비용이 유저의 기준가 이상되면 이모티콘 플러스 서비스에 가입한다.
  이모티콘을 구매한 비용이 유저의 기준가 미만이면 이모티콘 플러스 서비스에 가입하지 않고 이모티콘을 구매한다.
  이모티콘 할인율은 이모티콘마다 다를 수 있으며 10%, 20%, 30%, 40% 중 하나이다.
  이모티콘 할인율을 정할 때,
  1. 이모티콘 플러스 서비스에 가입한 사람의 수와
  2. 이모티콘을 구매한 비용의 합을 최대화하는 것이 목표이다.
  1번이 우선 2번은 차선.
  이모티콘 플러스 서비스에 가입한 사람의 수와 이모티콘을 구매한 비용의 합을 반환한다.

  📚 완전탐색[브루트포스], DFS(Permutation), 시뮬레이션
 */

/*
  * DFS를 사용한 완전탐색을 해도 4^7 = 16,384 * 100(유저수) * 7(이모티콘)로 충분히 가능하다.

  1. 할인율 조합 만들기 (DFS or 재귀)
  각 이모티콘에 대해 [10, 20, 30, 40] 중 하나 선택
  모든 조합 만들기 → 예: [30, 10], [20, 40], [40, 40] 등

  2. 각 조합마다 시뮬레이션 실행
  모든 유저에 대해:
  유저가 지정한 비율 이상 할인된 이모티콘만 구매
  총합이 기준 가격 이상이면 → 구매 취소 + 서비스 가입
  아니면 → 그대로 구매

  3. 가입자 수 & 매출 계산
  모든 유저에 대해 위 기준으로 계산 후
  (가입자 수, 판매금액) 반환

  4. 가장 가입자 수가 많은 조합을 고름
  동일한 가입자 수일 경우 → 판매금액이 더 큰 조합 선택
*/

package com.example.hello.codingTest;

public class Programmers {

  static int[][] users = {{40, 10000}, {25, 10000}};
  static int[] emoticons = {7000, 9000};

//  static int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
//  static int[] emoticons = {1300, 1500, 1600, 4900};

  public static void main(String[] args) {
    Solution solution = new Programmers().new Solution();
    int[] result = solution.solution(users, emoticons);
  }

  class Solution {
    int maxJoin = 0;
    int maxSales = 0;
    int[] discounts = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
      dfs(0, new int[emoticons.length], users, emoticons);
      System.out.println("maxJoin = " + maxJoin);
      System.out.println("maxSales = " + maxSales);
      return new int[]{maxJoin, maxSales};
    }

    void dfs(int idx, int[] discountSet, int[][] users, int[] emoticons) {
      if (idx == emoticons.length) {
        simulate(discountSet, users, emoticons);
        return;
      }

      for (int d : discounts) {
        discountSet[idx] = d;
        dfs(idx + 1, discountSet, users, emoticons);
      }
    }

    void simulate(int[] discountSet, int[][] users, int[] emoticons) {
      int join = 0;
      int sales = 0;

      for (int[] user : users) {
        int rate = user[0];
        int limit = user[1];
        int total = 0;

        for (int i = 0; i < emoticons.length; i++) {
          if (discountSet[i] >= rate) {
            int price = emoticons[i] * (100 - discountSet[i]) / 100;
            total += price;
          }
        }

        if (total >= limit) {
          join++;
        } else {
          sales += total;
        }
      }

      if (join > maxJoin || (join == maxJoin && sales > maxSales)) {
        maxJoin = join;
        maxSales = sales;
      }
    }
  }

}
```
