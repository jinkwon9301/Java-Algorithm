class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (65 <= s.charAt(i) && s.charAt(i) < 91) {
                if (s.charAt(i) + n < 91) sb.append((char)(s.charAt(i) + n));
                else sb.append((char)(s.charAt(i) + n - 26));
            } else if (97 <= s.charAt(i) && s.charAt(i) < 123) {
                if (s.charAt(i) + n < 123) sb.append((char)(s.charAt(i) + n));
                else sb.append((char)(s.charAt(i) + n - 26));
            }
            else sb.append(" ");
        }
        
        return sb.toString();
    }
}