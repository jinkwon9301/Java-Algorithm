import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        
        int answer_length = intervals[0][1] - intervals[0][0] + 1
                          + intervals[1][1] - intervals[1][0] + 1; 
        
        int[] answer = new int[answer_length];
        int answer_idx = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                answer[answer_idx++] = arr[j];   
            }
        }
        
        return answer;
        
    }
}