# [Gold V] 톱니바퀴 - 14891 

[문제 링크](https://www.acmicpc.net/problem/14891) 

### 성능 요약

메모리: 14312 KB, 시간: 108 ms

### 분류

구현, 시뮬레이션

### 제출 일자

2025년 4월 4일 12:03:59

### 문제 설명

<p>총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 아래 그림과 같이 일렬로 놓여져 있다. 또, 톱니는 N극 또는 S극 중 하나를 나타내고 있다. 톱니바퀴에는 번호가 매겨져 있는데, 가장 왼쪽 톱니바퀴가 1번, 그 오른쪽은 2번, 그 오른쪽은 3번, 가장 오른쪽 톱니바퀴는 4번이다.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/1.png" style="height:210px; width:918px"></p>

<p>이때, 톱니바퀴를 총 K번 회전시키려고 한다. 톱니바퀴의 회전은 한 칸을 기준으로 한다. 회전은 시계 방향과 반시계 방향이 있고, 아래 그림과 같이 회전한다.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/2.png" style="height:253px; width:660px"></p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/3.png" style="height:253px; width:602px"></p>

<p>톱니바퀴를 회전시키려면, 회전시킬 톱니바퀴와 회전시킬 방향을 결정해야 한다. 톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를 회전시킬 수도 있고, 회전시키지 않을 수도 있다. 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다. 예를 들어, 아래와 같은 경우를 살펴보자.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/4.png" style="height:223px; width:923px"></p>

<p>두 톱니바퀴의 맞닿은 부분은 초록색 점선으로 묶여있는 부분이다. 여기서, 3번 톱니바퀴를 반시계 방향으로 회전했다면, 4번 톱니바퀴는 시계 방향으로 회전하게 된다. 2번 톱니바퀴는 맞닿은 부분이 S극으로 서로 같기 때문에, 회전하지 않게 되고, 1번 톱니바퀴는 2번이 회전하지 않았기 때문에, 회전하지 않게 된다. 따라서, 아래 그림과 같은 모양을 만들게 된다.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/5.png" style="height:222px; width:921px"></p>

<p>위와 같은 상태에서 1번 톱니바퀴를 시계 방향으로 회전시키면, 2번 톱니바퀴가 반시계 방향으로 회전하게 되고, 2번이 회전하기 때문에, 3번도 동시에 시계 방향으로 회전하게 된다. 4번은 3번이 회전하지만, 맞닿은 극이 같기 때문에 회전하지 않는다. 따라서, 아래와 같은 상태가 된다.</p>

<p style="text-align:center"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14891/6.png" style="height:222px; width:921px"></p>

<p>톱니바퀴의 초기 상태와 톱니바퀴를 회전시킨 방법이 주어졌을 때, 최종 톱니바퀴의 상태를 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 1번 톱니바퀴의 상태, 둘째 줄에 2번 톱니바퀴의 상태, 셋째 줄에 3번 톱니바퀴의 상태, 넷째 줄에 4번 톱니바퀴의 상태가 주어진다. 상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.</p>

<p>다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)가 주어진다. 다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다. 각 방법은 두 개의 정수로 이루어져 있고, 첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다. 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.</p>

### 출력 

 <p>총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.</p>

<ul>
	<li>1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점</li>
	<li>2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점</li>
	<li>3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점</li>
	<li>4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점</li>
</ul>
---
📝 초기코드 실패 이유
```java
/*
❗ 문제 핵심
너는 좌측 톱니 회전과 우측 톱니 회전을 각각 따로 처리했는데,
이렇게 하면 좌측 회전 중 기어를 돌려버리면, 그 상태가 우측 회전 처리에 영향을 준다는 문제가 생겨.

즉, 기어 회전은 전파 여부 판단 → 실제 회전을 분리해서 진행해야 해.
*/

package com.example.hello.codingTest;

import java.util.*;
    import java.io.*;

class Main {
  static int N, result;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    LinkedList<Character>[] gears = new LinkedList[4];
    for (int i = 0; i < 4; i++) {
      gears[i] = new LinkedList<>();
    }

    for (int i = 0; i < 4; i++) {
      String line = br.readLine();
      for (char c : line.toCharArray()) {
        gears[i].add(c);
      }
    }

    int rotationCount = Integer.parseInt(br.readLine());
    for (int i = 0; i < rotationCount; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int gearIndex = Integer.parseInt(st.nextToken()) - 1;
      int direction = Integer.parseInt(st.nextToken());

      // 선택한 기어를 돌리기 전 좌우 기어의 회전 여부와 방향을 결정
      rotateLeftGears(gears, gearIndex, direction);
      rotateRightGears(gears, gearIndex, direction);
    }

    for (int i = 0; i < 4; i++) {
      result += gears[i].get(2) == '1' ? (int) Math.pow(2, i) : 0;
    }

    System.out.println(result);
  }

  private static void rotate(LinkedList<Character>[] gears, int gear, int direction) {
    if (direction == 1) {
      char last = gears[gear].removeLast();
      gears[gear].addFirst(last);
    } else {
      char first = gears[gear].removeFirst();
      gears[gear].addLast(first);
    }
  }

  private static void rotateLeftGears(LinkedList<Character>[] gears, int gearIndex, int direction) {
    // 현재 기어의 왼쪽면 NS극
    char currentGear = gears[gearIndex].get(0);

    // 왼쪽 기어의 오른쪽면 NS극과 비교하여 회전 여부 결정
    if (gearIndex > 0) {
      char leftGear = gears[gearIndex - 1].get(4);
      if (currentGear != leftGear) {
        // 왼쪽 기어를 회전시켜야 함
        rotateLeftGears(gears, gearIndex - 1, -direction);
      }
    }

    // 현재 기어 회전
    rotate(gears, gearIndex, direction);
  }

  private static void rotateRightGears(LinkedList<Character>[] gears, int gearIndex, int direction) {
    // 현재 기어의 왼쪽면 NS극
    char currentGear = gears[gearIndex].get(4);

    // 오른쪽 기어의 오른쪽면 NS극과 비교하여 회전 여부 결정
    if (gearIndex < 3) {
      char rightGear = gears[gearIndex + 1].get(0);
      if (currentGear != rightGear) {
        // 왼쪽 기어를 회전시켜야 함
        rotateRightGears(gears, gearIndex + 1, -direction);
      }
    }

    // 현재 기어 회전
    rotate(gears, gearIndex, direction);
  }
}

```
---
☝️ 올바르게 수정된 코드
```java
import java.util.*;
import java.io.*;

class Main {
  static int N, result;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    LinkedList<Character>[] gears = new LinkedList[4];
    for (int i = 0; i < 4; i++) {
      gears[i] = new LinkedList<>();
    }

    for (int i = 0; i < 4; i++) {
      String line = br.readLine();
      for (char c : line.toCharArray()) {
        gears[i].add(c);
      }
    }

    int rotationCount = Integer.parseInt(br.readLine());
    for (int i = 0; i < rotationCount; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int gearIndex = Integer.parseInt(st.nextToken()) - 1;
      int direction = Integer.parseInt(st.nextToken());

      int[] directions = new int[4];
      directions[gearIndex] = direction;

      // 왼쪽으로 전파
      for (int j = gearIndex; j > 0; j--) {
        char currentGear = gears[j].get(6);
        char leftGear = gears[j - 1].get(2);

        if (currentGear != leftGear) {
          directions[j - 1] = -directions[j];
        } else {
          break;
        }
      }

      // 오른쪽으로 전파
      for (int j = gearIndex; j < 3; j++) {
        char currentGear = gears[j].get(2);
        char rightGear = gears[j + 1].get(6);

        if (currentGear != rightGear) {
          directions[j + 1] = -directions[j];
        } else {
          break;
        }
      }

      // 회전
      for (int j = 0; j < 4; j++) {
        rotate(gears, j, directions[j]);
      }
    }

    // 점수 계산
    for (int i = 0; i < 4; i++) {
      result += gears[i].get(0) == '1' ? (int) Math.pow(2, i) : 0;
    }

    System.out.println(result);
  }

  private static void rotate(LinkedList<Character>[] gears, int gearIdx, int direction) {
    if (direction == 1) {
      char last = gears[gearIdx].removeLast();
      gears[gearIdx].addFirst(last);
    } else if (direction == -1) {
      char first = gears[gearIdx].removeFirst();
      gears[gearIdx].addLast(first);
    } else {
      // 방향이 0인 경우 회전하지 않음
      return;
    }
  }
}
```
