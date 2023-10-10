class Solution {
    public int solution(int n, int a, int b) {
        int count = 1;

        while (!(Math.abs(a - b) == 1 && Math.min(a, b) % 2 == 1)) {
          if (a % 2 == 1) a = a / 2 + 1;
          else a = a / 2;
          if (b % 2 == 1) b = b / 2 + 1;
          else b = b / 2;
          
          count++;
        }
        
        return count;
    }
}