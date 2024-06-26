# [Silver III] 2×n 타일링 - 11726 

[문제 링크](https://www.acmicpc.net/problem/11726) 

### 성능 요약

메모리: 17800 KB, 시간: 240 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2024년 6월 26일 23:00:00

### 문제 설명

<p>2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.</p>

<p>아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.</p>

<p style="text-align: center;"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11726/1.png" style="height:50px; width:125px"></p>

### 입력 

 <p>첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)</p>

### 출력 

 <p>첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.</p>

---
📝 풀이 과정
문제를 보고 경우의 수를 하나씩 그려보기로 했다.
![download (1)](https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/e769ee37-13d8-4069-9883-6011eec9ed74)

n = 4까지 그리고 난 뒤 확인해보면 일정한 패턴이 반복됨을 알 수 있었다.

노란색으로 체크된  n - 1의 타일에 세로 타일이 하나 추가된 모습이고,
파란색으로 체크된 n - 2의 타일에 가로 타일이 두 개 추가된 형태를가지고 있다.

따라서, dp[n] = dp[n−1] + dp[n−2] 라는 점화식을 가지게 된다.

💡 mod 연산을 한 결과값을 출력해야 할 때에는 반드시 연산할 때마다 mod 연산을 해주어야 한다. 계속 숫자를 더하고 마지막 출력시에만 mod연산을 해줄 경우 Integer.MAX_VALUE를 넘어 Overflow가 발생하기 때문에 잘못된 값이 출력될 수 있다.


출처 : [백준 11726번: 2×n 타일링 - JAVA](https://girawhale.tistory.com/33)
