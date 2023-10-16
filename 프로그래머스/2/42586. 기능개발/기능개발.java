import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length];
        int start_idx = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
          int work = 100 - progresses[i];
          arr[i] = (work % speeds[i] == 0) ? work / speeds[i] : work / speeds[i] + 1;
        }
        
        for (int i = 0; i < arr.length; i++) {
          int num = arr[i];
          for (int j = i; j < arr.length; j++) {
            arr[j] -= num;
          }
            
          start_idx = i;
          while (arr[i] <= 0) {
            i++;
            if (i == arr.length) {
              break;
            }
          }
            
          list.add(i - start_idx);
          i--;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}