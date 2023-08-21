class Solution {
    public int solution(int[] ingredient) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = 0; i < ingredient.length; i++) {
          sb.append(ingredient[i]);
          if (ingredient[i] == 1 && sb.length() >= 4 && sb.substring(sb.length() - 4, sb.length()).toString().equals("1231")) {
            count++;
            sb = new StringBuffer(sb.substring(0, sb.length() - 4));
          }
        }
        
        return count;
    }
}