import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        
        if (n == 1) {
            return Arrays.copyOfRange(num_list, 0, slicer[1] + 1);
        } else if (n == 2) {
            return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
        } else if (n == 3) {
            return Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
        }
        
        int n4_arr_length = ((slicer[1] - slicer[0] + 1) % slicer[2] == 0)
            ? (slicer[1] - slicer[0] + 1) / slicer[2]
            : (slicer[1] - slicer[0] + 1) / slicer[2] + 1;
        
        int[] n4_arr = new int[n4_arr_length];
        int idx = 0;
        
        for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
            n4_arr[idx++] = num_list[i];
        }
        
        return n4_arr;
        
    }
}