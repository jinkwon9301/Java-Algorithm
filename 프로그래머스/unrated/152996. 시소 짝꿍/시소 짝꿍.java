// 출처 : https://mag1c.tistory.com/295

import java.util.*;

class Solution {
    public long solution(int[] weights) {
    	long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int i : weights) {
    		double a = i*1.0;
    		double b = (i*2.0)/3.0;
    		double c = (i*1.0)/2.0;
    		double d = (i*3.0)/4.0;
    		if(map.containsKey(a)) answer += map.get(a);
    		if(map.containsKey(b)) answer += map.get(b);
    		if(map.containsKey(c)) answer += map.get(c);
    		if(map.containsKey(d)) answer += map.get(d);
    		map.put((i*1.0), map.getOrDefault((i*1.0), 0)+1);
        }
        
        return answer;
    }
}

/*
문제 풀이 전 생각한 것들을 정리하면 다음과 같다.

1. 위에서 얘기했듯 시간복잡도 고려.
2. Map을 활용하여 중복여부를 체크하면서 문제를 풀어나가자.
3. 정렬을 활용하여 뒤에오는 값들을 2/3, 1/2, 3/4만 해주면 되지 않을까, 굳이 클때 작을때 신경쓸 필요가 없다.


Stack처럼 활용하여 풀었다.
i의 값은 항상 map의 key값보다 크거나 같을 수 밖에 없다. 정렬을 했기 때문에.
그렇기 때문에, 문제에서 준 미터대로 2/3일때, 2/4일 때, 3/4일 때만 고려하여 접근했고, 기존 key값과 같으면 체크해서 answer을 올려주었다.
이 과정에서 map에 무게의 value를 weights의 개수로 넣게되면, 중복체크의 경우를 빼준다던가 할 것 없이 한번에 체크될 수 밖에 없다. weights가 100인사람이 3명일 경우 3이, 4명일 경우 6, 5명일 경우 10이 value가 될 것이다
( value는 누적합이 된다 )
*/