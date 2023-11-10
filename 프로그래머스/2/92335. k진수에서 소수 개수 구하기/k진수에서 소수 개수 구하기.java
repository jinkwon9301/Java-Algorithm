import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int count = 0;
        List<String> list = new ArrayList<>();
        boolean isRunning = false;
        int startIdx = 0;

        String k_jinsu = Integer.toString(n, k);

        for (int i = 0; i < k_jinsu.length(); i++) {
          if (i == k_jinsu.length() - 1 && k_jinsu.charAt(i) != '0') {
            if (startIdx == -1) list.add(k_jinsu.charAt(i) + "");
            else list.add(k_jinsu.substring(startIdx, k_jinsu.length()));
          }
          if (k_jinsu.charAt(i) != '0') {
            if (isRunning) continue;
            isRunning = true;
            startIdx = i;
          } else {
            if (!isRunning) continue;
            isRunning = false;
            list.add(k_jinsu.substring(startIdx, i));
            startIdx = -1;
          }
        }

        for (String s : list) {
          // s가 엄청 클 수 있다는 사실을 잊었다.
          long i = Long.parseLong(s);
          if (isPrime(i)) count++;
        }

        return count;
      }

      public static boolean isPrime(long i) {

        boolean isPrime = true;
        if (i == 1) return false;
        if (i == 2) return true;

        for (int j = 2; j <= Math.sqrt(i); j++) {
          if (i % j == 0) return false;
        }

        return true;
  }
}