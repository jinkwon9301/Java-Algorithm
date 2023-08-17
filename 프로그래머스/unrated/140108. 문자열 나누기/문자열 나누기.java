class Solution {
    public int solution(String s) {
        int result = 0;
        int x_count = 0;
        int notX_count = 0;
        char x = ' ';
        boolean isStart = true;

        for (int i = 0; i < s.length(); i++) {
          if (i == s.length() - 1) {
            result++;
            break;
          }
          if (isStart) {
            x = s.charAt(i);
            x_count++;
            isStart = false;
          }
          else {
            if (s.charAt(i) == x) {
              x_count++;
            } else {
              notX_count++;
            }
            if (x_count == notX_count) {
              System.out.println(s.charAt(i));
              result++;
              isStart = true;
            }
          }
        }
        
        return result;
    }
}