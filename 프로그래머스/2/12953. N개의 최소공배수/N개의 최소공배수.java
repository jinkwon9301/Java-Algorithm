class Solution {
    public int solution(int[] arr) {
        int a = arr[0];
        int b = 0;
        int tmp = 0;

        for (int i = 1; i < arr.length; i++) {
          b = arr[i];

          tmp = a;
          a = (a > b) ? a : b;
          b = (tmp < b) ? tmp : b;

          a = LCM(a, b);
        }
        
        return a;
    }

  static int GCD(int a, int b) {
    int tmp = 0;

    while (b != 0) {
      tmp = a;
      a = (a - b > b) ? a - b : b;
      b = (tmp - b < b) ? tmp - b : b;
    }

    return a;
  }

  static int LCM(int a, int b) {
    return a * b / GCD(a, b);
  }
}