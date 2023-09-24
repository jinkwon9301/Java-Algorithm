class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int min = 0;
        int max = 0;
        int count_zero = 0;
        int min_rank = 0;
        int max_rank = 0;

        for (int lotto : lottos) {
          if (lotto == 0) {
            count_zero++;
            continue;
          }
          for (int winNum : win_nums) {
            if (lotto == winNum) {
              min++;
              break;
            }
          }
        }

        max = min + count_zero;
        min_rank = rank(min);
        max_rank = rank(max);

        return new int[] { max_rank, min_rank };
    }
    
    static int rank(int count) {
        int rank;

        switch (count) {
          case 6:
            rank = 1;
            break;
          case 5:
            rank = 2;
            break;
          case 4:
            rank = 3;
            break;
          case 3:
            rank = 4;
            break;
          case 2:
            rank = 5;
            break;
          default:
            rank = 6;
            break;
        }

        return rank;
    }
}