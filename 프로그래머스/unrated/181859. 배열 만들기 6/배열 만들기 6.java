import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        
        while(i < arr.length) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                i++;
            } else if (stack.peek() == arr[i]) {
                stack.pop();
                i++;
            } else {
                stack.push(arr[i]);
                i++;
            }
            
            int[] answer = new int[stack.size()];
            int idx = 0;
        }
        
        int[] answer = new int[stack.size()];
        int idx = answer.length - 1;
        
        while(!stack.isEmpty()) {
            answer[idx--] = stack.pop();
        }
        
        if (answer.length == 0) 
            return new int[]{ -1 };
        
        return answer;
    }
}