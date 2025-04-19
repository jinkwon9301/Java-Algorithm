  class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

      String[] map = new String[n];

      for (int i = 0; i < n; i++) {
        int combined = arr1[i] | arr2[i];

        // 2진수 n자리로 변환 후, '1' -> '#', '0' -> ' '
        String line = String.format("%" + n + "s", Integer.toBinaryString(combined))
            .replace(' ', '0')  // 앞자리 0 채우기
            .replace('1', '#')
            .replace('0', ' ');

        map[i] = line;
      }

      return map;
    }
  }