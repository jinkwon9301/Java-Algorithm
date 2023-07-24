import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        int first = -1;
        int last = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                first = i;
                break;
            }
        }
        
        if (first == -1) {
            int[] answer = { -1 };
            return answer;
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                last = i;
                break;
            }
        }
        
        int answer_length = last - first + 1;
        int[] answer = new int[answer_length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[first++];
        }
        
        return answer;
    }
}