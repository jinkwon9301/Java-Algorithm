import java.util.*;

class Solution {
    public int solution(String number) {
        
        String[] arr = number.split("");
        
        int sum = 0;
        
        for (String e : arr) {
            sum += Integer.parseInt(e);
        }
        
        return sum % 9;
        
        
    }
}