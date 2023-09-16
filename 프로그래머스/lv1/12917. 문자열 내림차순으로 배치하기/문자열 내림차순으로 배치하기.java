import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        return String.join("",arr);
    }
}