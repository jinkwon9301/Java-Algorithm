class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder(new_id);

        for (int i = 0; i < sb.length(); i++) {
          if ('A' <= sb.charAt(i) && sb.charAt(i) <= 'Z') {
            sb.replace(i, i + 1, (char) (sb.charAt(i) + 32) + "");
          }
          else if (
              !('0' <= sb.charAt(i) && sb.charAt(i) <= '9') &&
                  !('a' <= sb.charAt(i) && sb.charAt(i) <= 'z') &&
                  !(sb.charAt(i) == '-' || sb.charAt(i) == '_' || sb.charAt(i) == '.')) {
            sb.delete(i, i + 1);
            i--;
          }
        }

        for (int i = 0; i < sb.length(); i++) {
          if (sb.charAt(i) == '.') {
            int n = 0;
            while (true) {
              if (sb.charAt(i + n++) != '.') break;
              if (i + n == sb.length()) break;
            }
            sb.replace(i, i + n - 1, ".");
            i++;
          }
        }

        if (sb.charAt(0) == '.') {
          sb.delete(0, 1);
        }

        if (sb.charAt(sb.length() - 1) == '.')  {
          sb.delete(sb.length() - 1, sb.length());
        }

        if (sb.length() == 0) {
          sb.append("a");
        }

        if (sb.length() >= 15) {
          sb.delete(15, sb.length());
        }

        if (sb.charAt(sb.length() - 1) == '.')  {
          sb.delete(sb.length() - 1, sb.length());
        }

        if (sb.length() <= 2) {
          while (sb.length() != 3) {
            sb.append(sb.charAt(sb.length() - 1));
          }
        }

        return sb.toString();
    }
}

/*
좋은 답안 : 빌더 패턴
class Solution {
    public String solution(String new_id) {

        String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();


        return s;
    }

    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }
}
*/