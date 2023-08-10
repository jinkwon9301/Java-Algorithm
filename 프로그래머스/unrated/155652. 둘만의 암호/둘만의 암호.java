import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        StringBuffer result = new StringBuffer();
        
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            char replace = s.charAt(i);
            boolean isSkip = false;
            while (count < index) {
                if ('a' <= (char) (replace + 1) && (char) (replace + 1) <= 'z')
                    replace = (char) (replace + 1);    
                else 
                    replace = (char) (replace - 25);
                for (int j = 0; j < skip.length(); j++) {
                    if (replace == skip.charAt(j)) {
                        isSkip = true;
                        break;
                    }
                }
                if (isSkip == true) {
                    isSkip = false;
                } else {
                    count++;
                }
            }
            result.append(replace);
        }
        
        
        
        return result.toString();
    }
}