import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuffer sb = new StringBuffer();
        String str = n + "";
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        System.out.println(Arrays.toString(ch));
        
        for (int i = ch.length - 1; i >= 0; i--) {
            sb.append(ch[i]);
        }
        return Long.parseLong(sb.toString());
    }
}