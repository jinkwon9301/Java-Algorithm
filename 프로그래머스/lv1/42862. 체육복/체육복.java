import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int num = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    num++;
                    reserve[i] = -1;
                    lost[j] = -1;
                    break;
                }
            }   
        }
        
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == -1) break;
                if (reserve[i] - 1  == lost[j] || reserve[i] + 1 == lost[j]) {
                    num++;
                    lost[j] = -1;
                    break;
                }
            }
        }
        
        return num;
        
    }
}