import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        int start = (l % 5 == 0) ? l : (l / 5) * 5 + 5;
        int last = r;
        
        for(int i = start; i <= last; i += 5) {
            String str = i + "";
            int count = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 48 || str.charAt(j) == 53) {
                    count ++;
                }
            }
            if(count == str.length()) {
                list.add(i);
            }
        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        int[] empty = {-1};
        if(answer.length == 0) return empty;
        return answer;
    }
}