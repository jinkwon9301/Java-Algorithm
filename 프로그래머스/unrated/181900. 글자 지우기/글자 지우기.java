class Solution {
    public String solution(String my_string, int[] indices) {
        
        char[] char_arr = my_string.toCharArray();
        
        for (int i = 0; i < indices.length; i++) {
            char_arr[indices[i]] = '1';
        }
        
        return String.valueOf(char_arr).replace("1", "");
    }
}