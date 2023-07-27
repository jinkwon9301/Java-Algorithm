import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        
        String[] horizontal_expansion = new String[picture.length];
        
        for (int i = 0; i < picture.length; i++) {
            StringBuffer sb = new StringBuffer();
            
            for (int j = 0; j < picture[i].length(); j++) {
                for (int l = 0; l < k; l++) {
                    sb.append(picture[i].charAt(j));
                }
            }
            
            horizontal_expansion[i] = sb.toString();
        }
        
        String[] answer = new String[picture.length * k];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = horizontal_expansion[i / k];
        }
        
        return answer;
        
    }
}