class Solution {
    public String solution(int n, int t, int m, int p) {
        int num = 0;
        StringBuffer sb = new StringBuffer();
        String str = "";
        StringBuffer answer = new StringBuffer();

        while(sb.length() < 100000) {
          sb.append(Integer.toString(num++, n));
        }

        str = sb.toString();

        for (int i = 0; i < str.length(); i++) {
          if (i % m == p - 1) answer.append(str.charAt(i));
          if (answer.length() == t) break;
        }

        return answer.toString().toUpperCase();
    }
}