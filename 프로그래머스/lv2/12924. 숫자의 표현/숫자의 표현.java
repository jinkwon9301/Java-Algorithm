class Solution {
    public int solution(int n) {
        int[] arr = new int[n];
        int sum = 1;
        int count = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
          arr[i] = i + 1;
        }

        while (true) {
          if (sum < n) {
            right++;
            if (right == n) break;
            sum += arr[right];
          }

          else if (n < sum) {
            left++;
            sum -= arr[left - 1];
          }

          else if (n == sum) {
            count++;
            left++;
            sum -= arr[left - 1];
            if (left == n - 1) break;
          }

          
        }

        return count;
    }
}