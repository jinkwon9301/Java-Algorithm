class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 11;
        int[][] location = {
            {3, 1},
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2},
            {3, 0}, {3, 2}
        };

        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
          if (number == 1 || number == 4 || number == 7) {
            sb.append('L');
            left = number;
          } else if (number == 3 || number == 6 || number == 9) {
            sb.append('R');
            right = number;
          } else {
            int left_distance =
                Math.abs(location[number][0] - location[left][0]) +
                Math.abs(location[number][1] - location[left][1]);
            int right_distance =
                Math.abs(location[number][0] - location[right][0]) +
                Math.abs(location[number][1] - location[right][1]);

            if (left_distance > right_distance) {
              sb.append('R');
              right = number;
            } else if (left_distance < right_distance) {
              sb.append('L');
              left = number;
            } else {
              if (hand.equals("right")) {
                sb.append('R');
                right = number;
              } else {
                sb.append('L');
                left = number;
              }
            }
          }
        }
        
        return sb.toString();
    }
}
