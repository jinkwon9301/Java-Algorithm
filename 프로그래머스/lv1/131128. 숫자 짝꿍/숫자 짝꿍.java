import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Integer, Integer> map_X = new HashMap<>();
        Map<Integer, Integer> map_Y = new HashMap<>();

        for (int i = 0; i < X.length(); i++) {
          int number = X.charAt(i) - '0';

          if (map_X.get(number) == null) map_X.put(number, 1);
          else map_X.put(number, map_X.get(number) + 1);
        }

        for (int i = 0; i < Y.length(); i++) {
          int number = Y.charAt(i) - '0';

          if (map_Y.get(number) == null) map_Y.put(number, 1);
          else map_Y.put(number, map_Y.get(number) + 1);
        }

        int[] arr = new int[10];
        for (int i = 9; i >= 0; i--) {
          if (map_X.get(i) == null || map_Y.get(i) == null) continue;
          arr[i] = (map_X.get(i) > map_Y.get(i)) ? map_Y.get(i) : map_X.get(i);
        }

        StringBuffer sb = new StringBuffer();
        int sum = 0;
        for (int i = 9; i >= 0; i--) {
          sum += (arr[i] > 0) ? i : 0;
          for (int j = 0; j < arr[i]; j++) {
            sb.append(i);
          }
        }
        
        if (sb.length() == 0) return "-1";
        else if (sum == 0) return "0";
        else return sb.toString();
    }
}