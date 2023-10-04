class Solution {
    public int[] solution(String s) {
        StringBuilder x = new StringBuilder();
        int change_count = 0;
        int delete_zero_count = 0;
        int c;

        while (s.length() != 1) {
          for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') x.append(s.charAt(i));
            else delete_zero_count++;
          }

          c = x.length();
          String result = Integer.toBinaryString(c);

          s = result;
          x.setLength(0);

          change_count++;
        }
        
        return new int[] {change_count, delete_zero_count};
    }
}