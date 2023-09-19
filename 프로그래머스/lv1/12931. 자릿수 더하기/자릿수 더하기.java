import java.util.*;

public class Solution {
    public int solution(int n) {
        String str = n + "";
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }
}