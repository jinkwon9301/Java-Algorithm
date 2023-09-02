import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack();
        
        for (int i : arr) {
          if (stack.empty() || stack.peek() != i) stack.push(i);
        }
        
        int[] result = new int[stack.size()];
        
        for (int i = 0; i < result.length; i++) {
          result[result.length - 1 - i] = stack.pop();
        }
        
        return result;
    }
}