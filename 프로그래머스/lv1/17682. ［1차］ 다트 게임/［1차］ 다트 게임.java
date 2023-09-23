class Solution {
    public int solution(String dartResult) {
        int sum = 0;
        int[] arr = new int[3];
        int idx = 0;

        for (int i = 0; i < dartResult.length(); i++) {
          if ('0' <= dartResult.charAt(i) && dartResult.charAt(i) <= '9') {
            if (dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
              arr[idx++] = 10;
              i++;
            }
            else arr[idx++] = dartResult.charAt(i) - '0';
          } else if (dartResult.charAt(i) == 'S') {
            arr[idx - 1] = (int) Math.pow(arr[idx - 1], 1);
          } else if (dartResult.charAt(i) == 'D') {
            arr[idx - 1] = (int) Math.pow(arr[idx - 1], 2);
          } else if (dartResult.charAt(i) == 'T') {
            arr[idx - 1] = (int) Math.pow(arr[idx - 1], 3);
          } else if (dartResult.charAt(i) == '*') {
            if (idx == 1) arr[idx - 1] = arr[idx - 1] * 2;
            else {
              arr[idx - 1] = arr[idx - 1] * 2;
              arr[idx - 2] = arr[idx - 2] * 2;
            }
          } else if (dartResult.charAt(i) == '#') {
            arr[idx - 1] = arr[idx - 1] * (-1);
          }
        }

        for (int i : arr) 
          sum += i;
        return sum;
    }
}