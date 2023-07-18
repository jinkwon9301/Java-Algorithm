import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
    
        int[] answer = new int[num_list.length];
        int idx = n;
        
        for (int i = 0; i < answer.length - n; i++) {
            answer[i] = num_list[idx++];
        }
        
        int idx2 = 0;
        
        for (int i = answer.length - n; i < answer.length; i++) {
            answer[i] = num_list[idx2++];
        }
        
        return answer;
        
    }
}