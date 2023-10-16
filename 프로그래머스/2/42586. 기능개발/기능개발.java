/*
// 다른 사람의 풀이 (큐 이용)
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
*/

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] arr = new int[progresses.length];
        int start_idx = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
          int work = 100 - progresses[i];
          arr[i] = (work % speeds[i] == 0) ? work / speeds[i] : work / speeds[i] + 1;
        }
        
        for (int i = 0; i < arr.length; i++) {
          int num = arr[i];
          for (int j = i; j < arr.length; j++) {
            arr[j] -= num;
          }
            
          start_idx = i;
          while (arr[i] <= 0) {
            i++;
            if (i == arr.length) {
              break;
            }
          }
            
          list.add(i - start_idx);
          i--;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}