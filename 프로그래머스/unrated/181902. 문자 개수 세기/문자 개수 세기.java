class Solution {
    public int[] solution(String my_string) {
        
        int[] answer = new int[52];
        
        for (int i = 0; i < my_string.length(); i++) {
            char target = my_string.charAt(i);
            if ('A' <= target && target <= 'Z') answer[target - 'A']++;
            else answer[target - 'a' + 26]++;
        }
        
        return answer;
    }
}