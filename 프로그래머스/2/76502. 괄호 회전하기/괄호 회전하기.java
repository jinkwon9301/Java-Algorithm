import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
          if (isRight(s)) count++;
          s = s.substring(1, s.length()) + s.charAt(0);
        }

        return count;
    }
  public static boolean isRight(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')) {
        return false;
      }
      else if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
        stack.push(s.charAt(i));
      }
      else if (s.charAt(i) == ')') {
        if (stack.peek() == '(') stack.pop();
        else return false;
      }
      else if (s.charAt(i) == ']') {
        if (stack.peek() == '[') stack.pop();
        else return false;
      }
      else if (s.charAt(i) == '}') {
        if (stack.peek() == '{') stack.pop();
        else return false;
      }
    }

    if (stack.isEmpty()) return true;
    else return false;
  }
}