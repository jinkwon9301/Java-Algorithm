class Solution {
    public int solution(int n, int m, int[] section) {
        int[] wall = new int[n];
        for (int i = 0; i < section.length; i++) {
          wall[section[i] - 1] = 1;
        }

        int count = 0;
        int idx = 0;

        while (true) {
          if (wall[idx] == 1) {
            count++;
            idx += m;
          } else {
            idx++;
          }
          if (idx >= wall.length) break;
        }
        
        return count;
    }
}