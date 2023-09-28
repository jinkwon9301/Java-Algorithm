import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] book_Time = new int[book_time.length][book_time[0].length];
        List<Integer> rooms = new ArrayList<>();

        for (int i = 0; i < book_time.length; i++) {
          int start_time;
          int end_time;

          String[] start_hhmm = book_time[i][0].split(":");
          String[] end_hhmm = book_time[i][1].split(":");

          start_time = Integer.parseInt(start_hhmm[0]) * 60 + Integer.parseInt(start_hhmm[1]);
          end_time = Integer.parseInt(end_hhmm[0]) * 60 + Integer.parseInt(end_hhmm[1]) + 10;

          book_Time[i][0] = start_time;
          book_Time[i][1] = end_time;
        }

        Arrays.sort(book_Time, (o1, o2) -> o1[0] - o2[0]);

        rooms.add(book_Time[0][1]);

        for (int i = 1; i < book_Time.length; i++) {
          int t1 = book_Time[i][0];
          int t2 = book_Time[i][1];
          boolean isChange = false;

          for (int j = 0; j < rooms.size(); j++) {
            int t3 = rooms.get(j);
            if (t3 <= t1) {
              rooms.set(j, t2);
              isChange = true;
              break;
            }
          }

          if (isChange == false) rooms.add(t2);
        }

        return rooms.size();
    }
}