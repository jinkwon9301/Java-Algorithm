class Solution {
    public int solution(String[] strArr) {
        int[] arr = new int[31];
        for (String str : strArr) {
            arr[str.length()]++;
        }
        
        int max = 0;
        
        for (int i : arr) {
            if (i > max) max = i;
        }
        
        return max;
    }
}