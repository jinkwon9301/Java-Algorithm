import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack();
        int count = 0;

        for (int move : moves) {
          int depth = 0;
          while (depth < board[0].length) {
            int doll = board[depth][move - 1];
            if (doll != 0) {
              if (!stack.empty() && doll == stack.peek()) {
                stack.pop();
                count++;
              } else {
                stack.push(doll);
              }
              board[depth][move - 1] = 0;
              break;
            }
            depth++;
          }
        }
        
        return count * 2;
    }
}