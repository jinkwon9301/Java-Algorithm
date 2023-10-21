import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[] prev = new int[4];
        int[] next = new int[4];
        int max = 0;

        prev = land[0];

        for (int i = 1; i < land.length; i++) {
          next = land[i];

          for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
              if (k != j) {
                max = Math.max(max, next[j] + prev[k]);
              }
            }
            next[j] = max;
            max = 0;
          }

          prev = next;
        }

        max = 0;

        for (int i = 0; i < 4; i++) {
          max = Math.max(max, prev[i]);  
        }
        
        return max;
    }
}