import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        int[][] answer = Arrays.stream(data)
            .filter(row -> row[map.get(ext)] < val_ext)
            .toArray(int[][]::new);

        Arrays.sort(answer, (a, b) -> Integer.compare(a[map.get(sort_by)], b[map.get(sort_by)]));
        
        return answer; 
    }
}