import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
    Map<String, Integer> map = new HashMap<>();
    int sum = 1;

    for (int i = 0; i < clothes.length; i++) {
      String key = clothes[i][1];

      if (map.get(key) == null) map.put(key, 1);
      else map.put(key, map.get(key) + 1);
    }

    for (Integer value : map.values()) {
      sum *= (value + 1);
    }

    return sum - 1;
    }
}