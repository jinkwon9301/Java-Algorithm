import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == '(') stack.push('(');
          else {
            if (stack.size() == 0) return false;
            stack.pop();
          }
        }
        
        return (stack.size() == 0);
    }
}