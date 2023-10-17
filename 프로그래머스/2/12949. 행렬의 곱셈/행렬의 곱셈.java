class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < result.length; i++) {
          for (int j = 0; j < result[0].length; j++) {
            int num = 0;
            for (int k = 0; k < arr2.length; k++) {
              num += arr1[i][k] * arr2[k][j];
            }
            result[i][j] = num;
          }
        }
        
        return result;
    }
}