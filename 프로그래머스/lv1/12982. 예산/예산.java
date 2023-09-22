import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int count = 0;
        int idx = 0;
        Arrays.sort(d);

        while (true) {
          if (budget >= d[idx]) {
            budget -= d[idx++];
            count++;
              if (idx == d.length) break;
          } else
            break;
        }
        
        return count;
    }
}