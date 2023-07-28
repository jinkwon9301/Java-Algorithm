import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int supoja1_answer_count = 0;
        int supoja2_answer_count = 0;
        int supoja3_answer_count = 0;
        
        int[] supoja2_arr = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] supoja3_arr = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == (i % 5) + 1) supoja1_answer_count++;
        }
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supoja2_arr[i % 8]) supoja2_answer_count++;
        }
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == supoja3_arr[i % 10]) supoja3_answer_count++;
        }
        
        int[] supojadle_answers_count_arr = { supoja1_answer_count, 
                                              supoja2_answer_count, 
                                              supoja3_answer_count };
        
        int max = 0;
        for (int i : supojadle_answers_count_arr) {
            if (max < i) max = i;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == supojadle_answers_count_arr[i]) list.add(i + 1);
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        
        return answer;
        
    }
}