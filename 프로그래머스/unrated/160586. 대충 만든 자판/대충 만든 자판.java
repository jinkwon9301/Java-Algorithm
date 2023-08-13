import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (String keys : keymap) {
          char[] keys_arr = keys.toCharArray();
          for (int i = 0; i < keys_arr.length; i++) {
            if (map.get(keys_arr[i]) == null) {
              map.put(keys_arr[i], i + 1);
              continue;
            }
            if (map.get(keys_arr[i]) > i + 1) map.put(keys_arr[i], i + 1);
          }
        }
        
        int[] result = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
          for (int j = 0; j < targets[i].length(); j++) {
            try {
              result[i] += map.get(targets[i].charAt(j));  
            } catch (NullPointerException e) {
              result[i] = -1;
              break;
            }
          }
        }
        
        return result;
    }
}