import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        List<Integer> list = new ArrayList<>();
        
        boolean isContained = false;
        
        for (int i = 0; i < arr.length; i++) {
            
            isContained = false;
            
            for (int e : delete_list) {
                if (e == arr[i]) isContained = true;
            }
            
            if (isContained) continue;
            list.add(arr[i]);
            
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}