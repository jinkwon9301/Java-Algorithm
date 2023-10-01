class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int remainder = 0;

        while (n != 0) {
          System.out.println(n);
          remainder = n % 3;
          n /= 3;
          if (remainder == 0) {
            remainder = 4;
            n -= 1;
          }

          sb.append(remainder);
        }

        return sb.reverse().toString();
    }
}