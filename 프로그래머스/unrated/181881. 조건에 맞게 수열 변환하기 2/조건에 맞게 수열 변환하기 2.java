import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        int num = 0;
        int[] arr2 = new int[arr.length];
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr2[i] = arr[i] / 2;    
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    arr2[i] = arr[i] * 2 + 1;
                } else {
                    arr2[i] = arr[i];
                }
            }
            if (Arrays.equals(arr, arr2)) break;
            
            arr = Arrays.copyOfRange(arr2, 0, arr2.length);
            num++;
        }
        
        return num;
        
    }
}