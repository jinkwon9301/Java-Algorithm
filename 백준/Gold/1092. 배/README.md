# [Gold V] 배 - 1092 

[문제 링크](https://www.acmicpc.net/problem/1092) 

### 성능 요약

메모리: 16892 KB, 시간: 360 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2024년 1월 11일 13:05:12

### 문제 설명

<p>지민이는 항구에서 일한다. 그리고 화물을 배에 실어야 한다. 모든 화물은 박스에 안에 넣어져 있다. 항구에는 크레인이 N대 있고, 1분에 박스를 하나씩 배에 실을 수 있다. 모든 크레인은 동시에 움직인다.</p>

<p>각 크레인은 무게 제한이 있다. 이 무게 제한보다 무거운 박스는 크레인으로 움직일 수 없다. 모든 박스를 배로 옮기는데 드는 시간의 최솟값을 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에는 각 크레인의 무게 제한이 주어진다. 이 값은 1,000,000보다 작거나 같다. 셋째 줄에는 박스의 수 M이 주어진다. M은 10,000보다 작거나 같은 자연수이다. 넷째 줄에는 각 박스의 무게가 주어진다. 이 값도 1,000,000보다 작거나 같은 자연수이다.</p>

### 출력 

 <p>첫째 줄에 모든 박스를 배로 옮기는데 드는 시간의 최솟값을 출력한다. 만약 모든 박스를 배로 옮길 수 없으면 -1을 출력한다.</p>

---

| 풀이

이 문제는 간단한 정렬과 그리디 알고리즘을 적용하여 풀 수 있다. 
 
먼저 크레인과 박스를 내림차순으로 정렬한다. 
이후 크레인과 박스를 순차적으로 대조하여 옮길 수 있다면 박스 리스트에서 박스를 제거한다.
 
간단한 방법이지만, 자료구조를 어떤 것을 사용하냐에 따라서 시간초과가 발생할 수 있다.
나는 처음에는 box를 제거할 때 시간이 O(1)밖에 걸리지 않는 LinkedList 자료구조를 사용했다.
하지만 LinkedList는 원소 접근에 O(n)의 시간이 걸리기 때문에 시간초과가 발생한다.
제거보다는 원소 접근을 더 많이 하므로 ArrayList를 이용하여 풀어야 시간초과가 발생하지 않는다.

| 코드

```java
import java.util.*;
import java.io.*;
 
public class Baekjoon_1092 {
    static int N,M;
    static ArrayList<Integer> crane;
    static ArrayList<Integer> box;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        crane = new ArrayList<>();
        for(int i=0; i<N; i++) {
            crane.add(sc.nextInt());
        }
        M = sc.nextInt();
        box = new ArrayList<>();
        for(int i=0; i<M; i++) {
            box.add(sc.nextInt());
        }
        
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
        
        if(box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }
        
        int ans = 0;
    
        while(!box.isEmpty()) {
            int idx =0;
            for(int i=0; i< N; ) {
                if(idx == box.size()) break;
                else if(crane.get(i) >= box.get(idx)) {
                    box.remove(idx);
                    i++;
                }else idx++;
            }
            ans++;
        }
        
        System.out.println(ans);
                
    }
 
}
```

출처 : [[백준] 1092번 배 (자바 풀이)](https://code-lab1.tistory.com/106)

---

코드설명

그리디 문제입니다.
이 문제는 그리디하게 가장 큰 크레인이 가장 큰 무게를 들 수 있도록 로직을 설계하면 됩니다.
 
처음에 틀리게 접근했던 방식은,
Crain과 Box 모두 오름차순으로 정렬합니다.
그리고서, 가장 작은 박스의 무게와 크레인들을 순회하며 크레인이 들 수 있는지 확인합니다.
틀린이유로는, 
가벼운 것만 먼저 싣다 보면 작은 것과 큰 것을 함께 옮겨야 최적이 되는 상황을 놓칠 수 있습니다.
오류입력예시로

```
입력
4
1 2 3 4
8
1 1 2 2 3 3 4 4

올바른 출력
2

오류 출력
4
```

* 제가 짠 코드는 무작정 오름차순으로 정렬한 Box를 Crain의 개수만큼의 Index만 검사하면서 돌기에, 
* (1,1,2,2,) (3 3), (4), (4)  로밖에 들지 못하므로 4의 시간이 걸립니다.
* 이렇게 짤경우, (1,2,3,4) (1,2,3,4) 라는 최적의 값을 찾지 못합니다.
 
위의 입력예시를 활용하여 올바른 로직을 정리해보았습니다.

```
입력
4
1 2 3 4
8
1 1 2 2 3 3 4 4
    
올바른 출력
2

오류 출력
4
```
 
crain이 내림차순 정렬되어 (4, 3, 2, 1) 입니다. 내림차순 정렬을 하는 이유는, 남은 박스중 무거운 박스부터 담아야 무거운 크레인이 가벼운 박스를 담는 일이 없습니다.
box가 내림차순 정렬되어 (4, 4, 3, 3, 2, 2, 1, 1) 입니다.
 
첫번쨰 크레인인 4가 4 를 돌고, 3이 4를 돌고, 2가 2를 돌고 1이 1을 돕니다.
또 4가 4 를 돌고, 3이 4를 돌고, 2가 2를 돌고 1이 1을 돕니다. 이렇게 되면 2번만에 처리가 가능합니다. 

 ```java
for(int j=0;j<box.length;j++) {
    if(visited[j] == true) continue; 
    if(crain[i] >= box[j]) {
        visited[j] = true;
        M--;
        break;
    }
}
 ```
 
위의 코드와 같이 단순히 모든 경우를 돌경우 시간초과가 발생합니다.
해당 코드는 crain이 box를 도는 과정의 코드입니다. 방문처리를 진행하고 있어서, 시간초과가 발생하지 않을 것 같다고 생각했지만, 방문하는 것만으로도 이미 조회과정을 거치니 시간초과가 발생합니다.
 
이 문제의 시간복잡도를 계산해보겠습니다. 문제 조건에 의하여 ( 0 < N <= 50 ), ( 0 < M <= 10000 ) 의 크기입니다.
크레인 하나당 최대 M ( 0 < M <= 10000 ) 번 순회합니다. 그러면 모든 크레인이 M번씩 순회한다고 가정하면 N  * M 번 입니다. 50 * 10000 입니다. 여기서 모든 M이  옮겨지려면, 최악의 경우 다시 M번을 순회해야합니다.즉, O(N M M ) 입니다. 50 * 10000 * 10000 = 5000000000 (50억) 의 시간이 걸릴 수 있습니다. ( 마지막에 M번 순회하는 과정은 모든 박스의 무게가 같다면 벌어집니다. )
 
이 과정에서 마지막에 다시 M번을 순회하는 과정을 줄이기 위해 크레인이 검사한 위치를 저장해주는 crain_position 배열을 활용하여 진행하면 시간초과가 해결됩니다. 처음에 저 같은경우, 크레인이 박스를 드는데 성공했을때만 crain_position을 갱신하였지만, 크레인이 들 수 없는 무게일때 계속해서 더해주는 처리를 해야 합니다. 그렇지 않다면, 크레인이 새로운 박스를 들 수 있을때까지 계속해서 순회하기에 시간초과가 발생합니다.
 
 
배열을 활용하여 진행할 수도 있지만, ArrayList의 remove 활용하여도 해결 가능합니다. 하지만, ArrayList의 경우 조회하는데 O(1) 의 시간, 삭제하는데 O(N)의 시간이 소요.
삭제가 이루어지지 않는 배열이 빠릅니다.
 
코드

배열을 활용한 정답코드 (가장 빠른 속도, ArrayList보다 거의 2배 빠름)

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	public static int N,M;
	public static Integer[] crain, box;
	public static int answer =0 ;
	public static boolean[] visited;
	public static int[] crain_positions;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	crain = new Integer[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		crain[i] = Integer.parseInt(st.nextToken());
    	}

    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	box = new Integer[M];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<M;i++) {
    		box[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	//내림차순으로 정렬하여야, 큰것들부터 처리합니다. (큰 크레인이 작은것들을 처리하는 일이 없어야만 합니다.)
    	Arrays.sort(crain, Collections.reverseOrder());
    	Arrays.sort(box, Collections.reverseOrder());
    	
    	
    	if(crain[0] < box[0]) {
    		System.out.println("-1"); 
    		return;
    	}

    	crain_positions = new int[N];
    	visited = new boolean[M];
    	//박스를 모두 옮기기전까지 작동
    	while(M > 0) {
    		
    		//각 크레인이 순회
    		for(int i=0;i<N;i++) {
    			if(M == 0) break;
    			
    			for(int j=crain_positions[i];j<box.length;j++) {
    				if(visited[j] == true) continue; 
    				if(crain[i] < box[j]) {
    					crain_positions[i]++;
    					continue;
    				}
    				else if(crain[i] >= box[j]) {
    					visited[j] = true;
    					M--;
    					break;
    				}
    			}
    			
//                비효율적인 코드
//    			for(int j=0;j<box.length;j++) {
//    				if(visited[j] == true) continue; 
//    				if(crain[i] >= box[j]) {
//    					visited[j] = true;
//    					M--;
//    					break;
//    				}
//    			}
    			
    		}
    		answer++;
    	}
    	System.out.println(answer);
    	
    }
}
 ```
 
ArrayList를 활용한 정답코드 (가장 느림)

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	public static int N,M;
	public static ArrayList<Integer> crain = new ArrayList<>();
	public static ArrayList<Integer> box = new ArrayList<>();
	public static int answer =0 ;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		crain.add(Integer.parseInt(st.nextToken()));
    	}

    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<M;i++) {
    		box.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	//내림차순으로 정렬하여야, 큰것들부터 처리합니다. (큰 크레인이 작은것들을 처리하는 일이 없어야만 합니다.)
    	Collections.sort(crain, Collections.reverseOrder());
    	Collections.sort(box, Collections.reverseOrder());
    	
    	
    	if( crain.get(0) < box.get(0)) {
    		System.out.println("-1"); 
    		return;
    	}
    	
    	while(box.size() > 0) {
    		
    		int boxIdx = 0;
    		for(int i=0;i<crain.size(); ) {
    			if(crain.get(i) >= box.get(boxIdx)) {
    				i++;
    				box.remove(boxIdx);
    			}
    			else if(crain.get(i) < box.get(boxIdx)) {
    				boxIdx++;
    			}
    			if(boxIdx == box.size()) break;
    		}
    		answer += 1;
    	}
    	
    	System.out.println(answer);
    	
    }
}
 ```
 
처음에 틀린코드

 ```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	
	public static int N,M;
	public static int[] crain, box;
	public static int answer =0 ;
	public static boolean[] visited;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	crain = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		crain[i] = Integer.parseInt(st.nextToken());
    	}

    	st = new StringTokenizer(br.readLine());
    	M = Integer.parseInt(st.nextToken());
    	box = new int[M];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<M;i++) {
    		box[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(crain);
    	Arrays.sort(box);
    	
    	
    	answer = 0;
    		
		int boxIndex = 0;
		while(true) {
			visited = new boolean[N];
			if(boxIndex >= box.length) break;
			for(int i=boxIndex;i<boxIndex + crain.length;i++) {
				if( i >= box.length) break; 
	    		int boxValue = box[i];
	    		
	    		for(int j=0;j<crain.length;j++) {
	    			if(visited[j]==true) continue;
	    			if(boxValue <= crain[j]) {
	    				boxIndex+=1;
	    				visited[j] = true;
	    				break;
	    			}
	    		}
	    	}
			answer += 1;
		}
		
    	System.out.println(answer);
    }
}
 ```


출처 : [[백준] 1092 배 - 그리디 JAVA](https://passionfruit200.tistory.com/m/461)
