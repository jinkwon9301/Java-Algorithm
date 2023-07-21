class Solution {
    public int[] solution(int[] arr) {
        
        int result_length = 1;
        
        while(result_length < arr.length) {
            result_length *= 2;
        }
        
        int[] result = new int[result_length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        
        return result;
        
    }
}