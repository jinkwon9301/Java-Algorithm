class Solution {
    public int[][] solution(int[][] arr) {
        
        int length = 0;
        if (arr[0].length < arr.length) length = arr.length;
        else length = arr[0].length;
        
        int[][] answer = new int[length][length];
        
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                if (i < arr.length && j < arr[0].length)
                    answer[i][j] = arr[i][j];
                else 
                    answer[i][j] = 0;
            }
        }
        
        return answer;
    }
}