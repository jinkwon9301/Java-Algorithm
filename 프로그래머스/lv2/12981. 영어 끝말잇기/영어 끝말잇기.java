import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        String last = "";
        String cur = "";
        int num = 0;
        int order = 0;
        
        map.put(words[0], true);
        last = words[0];
        
        for (int i = 1; i < words.length; i++) {
            cur = words[i];
            if (map.get(cur) != null || 
                last.charAt(last.length() - 1) != cur.charAt(0)) {
                num = i % n + 1;
                order = i / n + 1;
                break;
            }
            map.put(cur, true);
            last = words[i];
        }
        
        return new int[] { num, order };
    }
}