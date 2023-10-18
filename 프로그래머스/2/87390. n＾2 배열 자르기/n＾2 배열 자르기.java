class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int) (right - left + 1)];
        
        for (int i = 0; i < result.length; i++) {
          result[i] = (left % n <= left / n) ? 
            (int) (left / n + 1) : 
            (int) (left % n + 1);
          left++;
        }
        
        return result;
    }
}