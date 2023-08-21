class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        
        for (int i = left; i <= right; i++) {
            if ((int) Math.sqrt(i) == Math.sqrt(i)) sum -= i;
            else sum += i;
        }
        
        return sum;
    }
}