import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int deleted_num = tangerine.length - k;
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine)
          map.put(i, map.getOrDefault(i, 0) + 1);

        int[] arr = new int[map.size()];
        int idx = 0;

        for (Integer value : map.values())
          arr[idx++] = value;

        Arrays.sort(arr);
        int idx2 = 0;

        while (deleted_num > 0) {
          if (arr[idx2] == 0) {
            idx2++;
          }
          arr[idx2]--;
          deleted_num--;
        }

        for (int i : arr)
          if (i != 0) count++;

        return count;
    }
}