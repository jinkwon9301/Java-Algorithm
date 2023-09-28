// PriorityQueue, DP 풀이 방법 
// 참고 : https://tang25.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%98%B8%ED%85%94-%EB%8C%80%EC%8B%A4-Lv2-JAVA-%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84%ED%81%90%EC%97%84%ED%83%B1

// import java.util.*;

// class Solution {
//     public int solution(String[][] book_time) {
//         int[][] book_Time = new int[book_time.length][book_time[0].length];
//         List<Integer> rooms = new ArrayList<>();

//         for (int i = 0; i < book_time.length; i++) {
//           int start_time;
//           int end_time;

//           String[] start_hhmm = book_time[i][0].split(":");
//           String[] end_hhmm = book_time[i][1].split(":");

//           start_time = Integer.parseInt(start_hhmm[0]) * 60 + Integer.parseInt(start_hhmm[1]);
//           end_time = Integer.parseInt(end_hhmm[0]) * 60 + Integer.parseInt(end_hhmm[1]) + 10;

//           book_Time[i][0] = start_time;
//           book_Time[i][1] = end_time;
//         }

//         Arrays.sort(book_Time, (o1, o2) -> o1[0] - o2[0]);

//         rooms.add(book_Time[0][1]);

//         for (int i = 1; i < book_Time.length; i++) {
//           int t1 = book_Time[i][0];
//           int t2 = book_Time[i][1];
//           boolean isChange = false;

//           for (int j = 0; j < rooms.size(); j++) {
//             int t3 = rooms.get(j);
//             if (t3 <= t1) {
//               rooms.set(j, t2);
//               isChange = true;
//               break;
//             }
//           }

//           if (isChange == false) rooms.add(t2);
//         }

//         return rooms.size();
//     }
// }

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {

        int[][] bkt = new int[book_time.length][];

        for (int i = 0; i < book_time.length; i++) {
            bkt[i] = new int[] { parseTime(book_time[i][0]), parseTime(book_time[i][1]) + 10 };
        }

        Arrays.sort(bkt, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int ans = 0;

        for (int i = 0; i < bkt.length; i++) {
            if (!que.isEmpty() && que.peek()[1] <= bkt[i][0]) {
                que.poll();
            }
            que.add(bkt[i]);
            ans = Math.max(ans, que.size());
        }

        return ans;
    }

    protected int parseTime(String time) {

        String[] hhmm = time.split(":");
        int hour = Integer.parseInt(hhmm[0]), min = Integer.parseInt(hhmm[1]);
        return hour * 60 + min;

    }
}