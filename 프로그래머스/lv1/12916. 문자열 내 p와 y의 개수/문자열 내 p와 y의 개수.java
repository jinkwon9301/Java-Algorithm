class Solution {
    boolean solution(String s) {
        int p_count = 0;
        int y_count = 0;
        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == 'p' || s.charAt(i) == 'P') p_count++;
          if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') y_count++;
        }

        return p_count == y_count;
    }
}