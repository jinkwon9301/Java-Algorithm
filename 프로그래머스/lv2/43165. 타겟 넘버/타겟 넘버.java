class Solution {
    
    static int total = 0;
    static int count = 0;
    static int idx = -1;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target);
        return count;
    }
    
  static void dfs(int num, int[] numbers, int target) {
    total += num;

    if (idx == numbers.length - 1) {
      if (total == target) count++;
      total -= num;
      idx--;
      return;
    }
    dfs(numbers[++idx], numbers, target);
    dfs(-numbers[++idx], numbers, target);
    idx--;
    total -= num;
  }
}