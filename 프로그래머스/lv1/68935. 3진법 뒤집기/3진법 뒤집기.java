class Solution {
    public int solution(int n) {
        
        StringBuffer sb = new StringBuffer();
        
        while (n != 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        String str = new String(sb);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += (str.charAt(i) - '0') * Math.pow(3, str.length() - 1 - i);
        }
        
        return result;
    }
}