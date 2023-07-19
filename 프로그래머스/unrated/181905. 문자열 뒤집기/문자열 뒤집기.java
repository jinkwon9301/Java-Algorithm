class Solution {
    public String solution(String my_string, int s, int e) {
        
        String target_str = my_string.substring(s, e + 1);
        StringBuffer target_reverse = new StringBuffer();
        for (int i = target_str.length() - 1; i >= 0; i--) {
            target_reverse.append(target_str.charAt(i));
        }
        
        return my_string.substring(0, s)
        + target_reverse.toString()
        + my_string.substring(e + 1, my_string.length());
        
    }
}