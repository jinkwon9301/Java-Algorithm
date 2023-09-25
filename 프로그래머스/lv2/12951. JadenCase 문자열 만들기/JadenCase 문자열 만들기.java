class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        boolean toUpperCase = true;

        for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == ' ') {
            result.append(' ');
            toUpperCase = true;
          } else {
            if (!toUpperCase) {
              result.append((s.charAt(i) + "").toLowerCase());
            } else {
              result.append((s.charAt(i) + "").toUpperCase());
              toUpperCase = false;
            }
          }
        }

        return result.toString();
    }
}