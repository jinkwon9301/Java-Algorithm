class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++, j++) {
          if (s.charAt(i) == ' ') {
            sb.append(' ');
            j = -1;
          }
          else {
            if (j % 2 == 0 && s.charAt(i) <= 'Z') sb.append(s.charAt(i));
            if (j % 2 == 0 && s.charAt(i) > 'Z') sb.append((char) (s.charAt(i) - 32));

            if (j % 2 == 1 && s.charAt(i) <= 'Z') sb.append((char)(s.charAt(i) + 32));
            if (j % 2 == 1 && s.charAt(i) > 'Z') sb.append(s.charAt(i));
          }
        }
        
        return sb.toString();
    }
}