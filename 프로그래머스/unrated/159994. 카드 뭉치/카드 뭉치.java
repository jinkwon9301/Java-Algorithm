class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx_c1 = 0;
        int idx_c2 = 0;

        for (int i = 0; i < goal.length; i++) {
          if (idx_c1< cards1.length && 
              goal[i].equals(cards1[idx_c1])) {
            idx_c1++;
            continue;
          }
          else if (idx_c2 < cards2.length && 
                   goal[i].equals(cards2[idx_c2])) {
            idx_c2++;
            continue;
          }
          else {
            return "No";
          }
        }
        return "Yes";
    }
}