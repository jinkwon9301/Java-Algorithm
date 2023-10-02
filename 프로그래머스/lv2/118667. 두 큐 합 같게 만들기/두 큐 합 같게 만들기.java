/*
문제를 겪으시는 부분은 크게 두가지일것 같습니다

탈출조건
시간초과
먼저 탈출조건부터 생각해봅시다

단순히 어느 값을 기준으로 잡기는 어려우니 최악의 케이스를 찾아보겠습니다

queue1에서 queue2로 모든값을 보내고 queue2에서 하나만을 제외하고 모두 queue1으로 내보내는 케이스 입니다

이보다 더 최악의 수는 없는 것 같습니다

때문에 queue1의 길이의 3배(queue1, queue2의 길이가 같으므로)까지 순회한 경우 -1을 리턴해주면 되겠습니다
*/

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> queue_1 = new LinkedList<>();
        Queue<Integer> queue_2 = new LinkedList<>();
        long sum_queue1 = 0;
        long sum_queue2 = 0;
        int count = 0;
        int temp = 0;

        for (int i : queue1) {
          queue_1.offer(i);
          sum_queue1 += i;
        }

        for (int i : queue2) {
          queue_2.offer(i);
          sum_queue2 += i;
        }

        while (sum_queue1 != sum_queue2) {
          if (sum_queue1 < sum_queue2) {
            temp = queue_2.poll();
            queue_1.offer(temp);
            sum_queue1 += temp;
            sum_queue2 -= temp;
            count++;
          }

          else if (sum_queue1 > sum_queue2) {
            temp = queue_1.poll();
            queue_2.offer(temp);
            sum_queue1 -= temp;
            sum_queue2 += temp;
            count++;
          }

          if (count > queue1.length * 4) return -1;
        }
        
        return count;
    }
}