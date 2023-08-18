class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 0;

        for (int i = 1; i <= number; i++) {
          int attack_power = divisor_count(i);

          if (attack_power <= limit) sum += attack_power;
          else sum += power;
        }
        
        return sum;
    }
    
    static int divisor_count(int num) {
        int count = 0;

        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (i == Math.sqrt(num)) {
                count++;
                break;
            }
            if (num % i == 0) count += 2;
        }
        
        return count;
     }
}