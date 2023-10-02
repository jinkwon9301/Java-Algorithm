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