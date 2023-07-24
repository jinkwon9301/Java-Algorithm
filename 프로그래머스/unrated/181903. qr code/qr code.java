import java.util.*;

class Solution {
    public String solution(int q, int r, String code) {
        
        char[] char_arr = code.toCharArray();
        
        StringBuffer answer = new StringBuffer();
        
        for (int i = 0; i < char_arr.length; i++) {
            if (i % q == r) answer.append(char_arr[i]);
        }
        return answer.toString();
    }
}