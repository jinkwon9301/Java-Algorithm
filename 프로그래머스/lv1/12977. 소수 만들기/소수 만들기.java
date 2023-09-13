class Solution {
    public int solution(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
          for (int j = i + 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
              count += isPrime(nums[i] + nums[j] + nums[k]) ? 1 : 0;    
            }
          }
        }
        
        return count;
    }
    
    static boolean isPrime(int num) {
      for (int i = 2; i <= Math.sqrt(num); i++)
        if (num % i == 0) return false;
      return true;
    }
}