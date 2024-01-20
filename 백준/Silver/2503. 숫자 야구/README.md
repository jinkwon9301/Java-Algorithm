# [Silver III] 숫자 야구 - 2503 

[문제 링크](https://www.acmicpc.net/problem/2503) 

### 성능 요약

메모리: 16568 KB, 시간: 188 ms

### 분류

브루트포스 알고리즘, 구현

### 제출 일자

2024년 1월 20일 12:29:42

### 문제 설명

<p>정보문화진흥원 정보 영재 동아리에서 동아리 활동을 하던 영수와 민혁이는 쉬는 시간을 틈타 숫자야구 게임을 하기로 했다.</p>

<ul>
	<li>영수는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 마음속으로 생각한다. (예: 324)</li>
	<li>민혁이는 1에서 9까지의 서로 다른 숫자 세 개로 구성된 세 자리 수를 영수에게 묻는다. (예: 123)</li>
	<li>민혁이가 말한 세 자리 수에 있는 숫자들 중 하나가 영수의 세 자리 수의 동일한 자리에 위치하면 스트라이크 한 번으로 센다. 숫자가 영수의 세 자리 수에 있긴 하나 다른 자리에 위치하면 볼 한 번으로 센다.</li>
</ul>

<p>예) 영수가 324를 갖고 있으면 </p>

<ul>
	<li>429는 1 스트라이크 1 볼이다.</li>
	<li>241은 0 스트라이크 2 볼이다.</li>
	<li>924는 2 스트라이크 0 볼이다.</li>
	<li>영수는 민혁이가 말한 수가 몇 스트라이크 몇 볼인지를 답해준다.</li>
	<li>민혁이가 영수의 세 자리 수를 정확하게 맞추어 3 스트라이크가 되면 게임이 끝난다. 아니라면 민혁이는 새로운 수를 생각해 다시 영수에게 묻는다.</li>
</ul>

<p>현재 민혁이와 영수는 게임을 하고 있는 도중에 있다. 민혁이가 영수에게 어떤 수들을 물어보았는지, 그리고 각각의 물음에 영수가 어떤 대답을 했는지가 입력으로 주어진다. 이 입력을 바탕으로 여러분은 영수가 생각하고 있을 가능성이 있는 수가 총 몇 개인지를 알아맞혀야 한다.</p>

<p>아래와 같은 경우를 생각해보자.  </p>

<ul>
	<li>민혁: 123</li>
	<li>영수: 1 스트라이크 1 볼.</li>
	<li>민혁: 356</li>
	<li>영수: 1 스트라이크 0 볼.</li>
	<li>민혁: 327</li>
	<li>영수: 2 스트라이크 0 볼.</li>
	<li>민혁: 489</li>
	<li>영수: 0 스트라이크 1 볼.</li>
</ul>

<p>이때 가능한 답은 324와 328, 이렇게 두 가지이다.</p>

<p>영수는 동아리의 규율을 잘 따르는 착한 아이라 민혁이의 물음에 곧이곧대로 정직하게 답한다. 그러므로 영수의 답들에는 모순이 없다.</p>

<p>민혁이의 물음들과 각각의 물음에 대한 영수의 답이 입력으로 주어질 때 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에는 민혁이가 영수에게 몇 번이나 질문을 했는지를 나타내는 1 이상 100 이하의 자연수 N이 주어진다. 이어지는 N개의 줄에는 각 줄마다 민혁이가 질문한 세 자리 수와 영수가 답한 스트라이크 개수를 나타내는 정수와 볼의 개수를 나타내는 정수, 이렇게 총 세 개의 정수가 빈칸을 사이에 두고 주어진다.</p>

### 출력 

 <p>첫 줄에 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력한다.</p>

---

<img width="778" alt="Screenshot 2024-01-20 at 12 31 53 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/618a8cee-2fd3-46a0-ae5b-97f4785c5d7e">

<img width="818" alt="Screenshot 2024-01-20 at 12 32 11 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/36e9f451-65fb-4e01-bb57-02b16d2a9677">

<img width="805" alt="Screenshot 2024-01-20 at 12 32 22 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/d98c3ff9-4d78-4ed7-95ab-55b8e645cbba">

<img width="811" alt="Screenshot 2024-01-20 at 12 32 29 PM" src="https://github.com/jinkwon9301/Java-Algorithm/assets/77374066/e14b5e6b-4731-4b29-9737-711cb13ee59b">

```java
import java.io.*;
import java.util.*;


public class Main {
    //숫자 야구 응답 정보 관련 클래스
    static class info{
        int strike, ball;
        String num;
        public info(String num, int strike, int ball){
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
    static int N;
    static ArrayList<info> game = new ArrayList<>();	//숫자 야구 응답 저장 리스트
    static ArrayList<String> answer = new ArrayList<>();	//정답 가능한 숫자 저장 리스트
    static boolean[] numUsing;		//숫자 사용 여부 확인 배열
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        numUsing = new boolean[10];
        StringTokenizer st;
        //응답 관련 정보 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String num = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            game.add(new info(num, s, b));
        }
        search("", 0);	//숫자야구 모든 경우의 수 탐색
        bw.write(answer.size() + "");	//정답이 가능한 숫자개수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //숫자야구의 모든 경우 만드는 함수
    static void search(String num, int size){
        //완성된 경우 모든 응답 만족하는지 확인하기.
        if(size == 3){
            numCheck(num);
            return;
        }
        //숫자야구에 나올 수 있는 숫자 만들기.
        for(int i=1;i<=9;i++){
            if(!numUsing[i]){
                numUsing[i] = true;
                search(num + i, size + 1);
                numUsing[i] = false;
            }
        }
    }
    //숫자가 모든 응답에 만족하는지 확인하는 함수
    static void numCheck(String num){
        //모든 응답에 대하여 만족하는지 탐색
        for(info cur : game){
            int s = 0;
            int b = 0;
            //스트라이크 조건 만족하는지 확인
            for(int i=0;i<3;i++)
                if(cur.num.charAt(i) == num.charAt(i))
                    s++;

            if(cur.strike != s)
                return;
            //볼 조건 만족하는지 확인
            for(int i=0;i<3;i++){
                int temp = (i + 1) % 3;
                if(num.charAt(i) == cur.num.charAt(temp))
                    b++;
                temp = (i + 2) % 3;
                if(num.charAt(i) == cur.num.charAt(temp))
                    b++;
            }

            if(cur.ball != b)
                return;
        }
        //모든 조건 만족할 때 추가
        answer.add(num);
    }
}
```

출처 : [[백준] 알고리즘 분류(브루트 포스,JAVA)2503번, 숫자 야구](https://tussle.tistory.com/912)
