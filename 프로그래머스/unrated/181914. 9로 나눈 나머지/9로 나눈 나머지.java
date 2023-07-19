import java.util.*;

class Solution {
    public int solution(String number) {
        
//         String[] arr = number.split("");
        
//         int sum = 0;
        
//         for (String e : arr) {
//             sum += Integer.parseInt(e);
//         }
        
//         return sum % 9;

        int answer = 0;

        for(int i=0; i<number.length(); i++) {
            answer += number.charAt(i) - '0';
        }

        answer %= 9;

        return answer;
        
        
    }
}