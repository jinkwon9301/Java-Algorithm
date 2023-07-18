import java.util.*;

class Solution {
    public String[] solution(String myString) {
        
        String[] arr = myString.split("x");
        Arrays.sort(arr);
        
        List<String> list = new ArrayList<>();
        for (String e : arr) {
            if (e.length() > 0) list.add(e);
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
        
    }
}