import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] result = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
          int[] arr_cut = 
              Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
          int[] arr_sort = Arrays.copyOf(arr_cut, arr_cut.length);
          Arrays.sort(arr_sort);
          result[i] = arr_sort[commands[i][2] - 1];
        }
        
        return result;
    }
}