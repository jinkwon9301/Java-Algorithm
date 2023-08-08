import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int sum = 0;
        int[] score = new int[photo.length];
        int score_idx = 0;
        
        for (String[] group : photo) {
            for (String str : group) {
                if (map.get(str) == null) continue;
                sum += map.get(str);
            }
            score[score_idx++] = sum;
            sum = 0;
        }
        
        return score;
    }
}