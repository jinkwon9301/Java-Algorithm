import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int[] arr = new int[elements.length * 2];
        int start = 0;
        int end = 0;
        int sum = elements[0];
        boolean isIncrease = true;

        for (int i = 0; i < arr.length; i++) {
          if (i < elements.length) arr[i] = elements[i];
          else arr[i] = elements[i - elements.length];
        }

        set.add(arr[0]);

        while (true) {
          if (isIncrease && (end - start) < (elements.length - 1)) {
            end++;
            sum += arr[end];
            set.add(sum);
          }
          else if (isIncrease && (end - start) == (elements.length - 1)) {
            sum -= arr[start];
            start++;
            end++;
            sum += arr[end];
            set.add(sum);
            isIncrease = false;
          }
          else if (!isIncrease && (end - start) != 0) {
            sum -= arr[end];
            end--;
            set.add(sum);
          }
          else if (!isIncrease && end == start) {
            start++;
            end++;
            sum = arr[start];
            set.add(sum);
            isIncrease = true;
          }
          if (start == elements.length) break;
        }
        
        return set.size();
    }
}