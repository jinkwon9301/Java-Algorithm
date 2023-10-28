import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        String[] split = s.split(",");

        for (String s1 : split) {
          StringBuffer sb = new StringBuffer();
          for (int i = 0; i < s1.length(); i++) {
            char s2 = s1.charAt(i);
            if ('0' <=  s2 && s2 <= '9') sb.append(s2);
          }
          int j = Integer.parseInt(sb.toString());
          map.put(j, map.getOrDefault(j, 0) + 1);
        }

        for (Integer value : map.values()) {
          max = Math.max(max, value);
        }

        int[] arr = new int[max];

        for (Integer key : map.keySet()) {
          Integer value = map.get(key);
          arr[max - value] = key;
        }

        return arr;
    }
}