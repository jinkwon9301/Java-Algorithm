import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        
        List<Integer> list = new ArrayList<>();
        
        for (String e : intStrs) {
            int targetInt = Integer.parseInt(e.substring(s, s + l));
            if (targetInt > k) list.add(targetInt);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
        
    }
}