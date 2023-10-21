import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer[]> queue = new LinkedList<>();

        int count = 0;
        Integer[] num;
        int idx = 0;
        int value = 0;
        boolean canOut = false;

        for (int i = 0; i < 10; i++) {
          map.put(i, 0);
        }

        for (int i = 0; i < priorities.length; i++) {
          map.put(priorities[i], map.get(priorities[i]) + 1);
        }

        for (int i = 0; i < priorities.length; i++) {
          queue.offer(new Integer[]{i, priorities[i]});
        }

        while (!queue.isEmpty()) {
          num = queue.poll();
          idx = num[0];
          value = num[1];
          canOut = true;

          for (int i = value + 1; i < 10; i++) {
            if (map.get(i) >= 1) {
              queue.offer(num);
              canOut = false;
              break;
            }
          }

          if (canOut) {
            map.put(value, map.get(value) - 1);
            count++;
            if (num[0] == location) return count;
          }
        }
        
        return 0;
    }
}