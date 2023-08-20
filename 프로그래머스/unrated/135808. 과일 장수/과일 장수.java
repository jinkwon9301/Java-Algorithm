class Solution {
    public int solution(int k, int m, int[] score) {
        int[] bucket = new int[k + 1];
        
        for (int i = 0; i < score.length; i++) {
          bucket[score[i]]++;
        }

        int min_score = 0;
        int apple_count = 0;
        int sum = 0;

        for (int i = bucket.length - 1; i >= 0; i--) {
          while (bucket[i] != 0) {
            bucket[i]--;
            apple_count++;
            if (apple_count == m) {
              min_score = i;
              sum += min_score * m;
              apple_count = 0;
            }
          }
        }
        
        return sum;
    }
}