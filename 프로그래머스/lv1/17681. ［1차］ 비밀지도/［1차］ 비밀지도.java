class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] result1 = new int[n][n];

        findWall(arr1, result1, n);
        findWall(arr2, result1, n);

        String[] result2 = new String[n];
        for (int i = 0; i < n; i++) {
          StringBuilder sb = new StringBuilder();
          for (int j = 0; j < n; j++) {
            sb.append(result1[i][j] == 1 ? '#' : ' ');
          }
          result2[i] = sb.toString();
        }
        
        return result2;
    }
    
    static void findWall(int[] arr, int[][] result, int n) {
    for (int i = 0; i < arr.length; i++) {
      int i1 = arr[i];
      long binary = 0;
      int k = 0;
      while (i1 != 0) {
        binary = binary + (i1 % 2) * (long)Math.pow(10, k++);
        i1 /= 2;
      }
      String binary_str = binary + "";
      if (binary_str.length() != n) {
        while (binary_str.length() != n) {
          binary_str = 0 + binary_str;
        }
      }

      for (int j = 0; j < binary_str.length(); j++) {
        if (binary_str.charAt(j) == '1') result[i][j] = 1;
      }
    }
  }
}