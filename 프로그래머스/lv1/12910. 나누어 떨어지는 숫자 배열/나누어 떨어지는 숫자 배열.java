import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        if (divisor == 1) {
            Arrays.sort(arr);
            return arr;
        }
        
        int[] result = Arrays.stream(arr)
            .filter(x -> x % divisor == 0)
            .sorted()
            .toArray();

        if (result.length == 0) return new int[] { -1 };

        return result;
    }
}