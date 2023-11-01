import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        Map<String, Integer> map = new HashMap<>();
        int total = 0;
        int count = 0;
        String word = "";

        for (int i = 0; i < str1.length() - 1; i++) {
          word = str1.substring(i, i + 2).toUpperCase();
          if ('A' <= word.charAt(0) && word.charAt(0) <= 'Z' && 'A' <= word.charAt(1) && word.charAt(1) <= 'Z') {
            map.put(word, map.getOrDefault(word, 0) + 1);
            total++;
          }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
          word = str2.substring(i, i + 2).toUpperCase();
          if ('A' <= word.charAt(0) && word.charAt(0) <= 'Z' && 'A' <= word.charAt(1) && word.charAt(1) <= 'Z') {
            if (map.get(word) != null && map.get(word) != 0) {
              map.put(word, map.get(word) - 1);
              count++;
            } else {
              total++;
            }
          }
        }
        if (total == 0) return 65536;
        return (int) (count / (float) total * 65536);
    }
}
