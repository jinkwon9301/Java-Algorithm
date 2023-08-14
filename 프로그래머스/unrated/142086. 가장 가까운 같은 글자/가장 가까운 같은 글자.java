import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
          if (map.get(s.charAt(i)) == null) {
            result[i] = -1;
            map.put(s.charAt(i), i);
          } else {
            result[i] = i - map.get(s.charAt(i));
            map.put(s.charAt(i), i);
          }
        }
        
        return result;
    }
}