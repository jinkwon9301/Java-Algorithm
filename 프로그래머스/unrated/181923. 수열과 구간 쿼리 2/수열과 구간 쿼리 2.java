class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        
        int[] answer = new int[queries.length];
        int idx = 0;
        
        for (int i = 0; i < queries.length; i++) {
            int min = 1_000_001;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (queries[i][2] < arr[j] && arr[j] < min) min = arr[j];
            }
            if (min == 1_000_001) answer[idx++] = -1;
            else answer[idx++] = min;
        }
        
        return answer;
        
    }
}