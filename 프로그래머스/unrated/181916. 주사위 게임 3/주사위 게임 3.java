import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        int[] arr = new int[7];
        arr[a]++;
        arr[b]++;
        arr[c]++;
        arr[d]++;
        
        int max = 0;
        int max_count = 0;
        int min = 0;
        int min_count = 4;
        
        for (int i = 0; i < arr.length; i++) {
            if (max_count <= arr[i]) {
                max = i;
                max_count = arr[i];
            } 
            if (0 < arr[i] && arr[i] < min_count) {
                min = i;
                min_count = arr[i];
            }
        }
        
        if (max_count == 4) return 1111 * a;
        else if (max_count == 3) {
            return (10 * max + min) * (10 * max + min);
        }
        else if (max_count == 2 && min_count == 2) {
            return (max + min) * Math.abs(max - min);
        }
        else if (max_count == 2 && min_count == 1) {
            int answer = 1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) answer *= i;
            }
            return answer;
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) return i;
            }
        }
        return 0;
    }
}