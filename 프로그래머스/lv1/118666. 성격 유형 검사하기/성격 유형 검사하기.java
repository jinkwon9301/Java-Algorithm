import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('M', 0);
        map.put('J', 0);
        map.put('N', 0);
        map.put('A', 0);

        for (int i = 0; i < survey.length; i++) {
          String questionnaire = survey[i];
          int choice = choices[i];

          if (choices[i] <= 3) map.put(questionnaire.charAt(0), map.get(questionnaire.charAt(0)) + (4 - choices[i]));
          if (5 <= choices[i]) map.put(questionnaire.charAt(1), map.get(questionnaire.charAt(1)) + (choices[i] - 4));
        }

        String result = "";
        result += (map.get('R') >= map.get('T')) ? 'R' : 'T';
        result += (map.get('C') >= map.get('F')) ? 'C' : 'F';
        result += (map.get('J') >= map.get('M')) ? 'J' : 'M';
        result += (map.get('A') >= map.get('N')) ? 'A' : 'N';
        
        return result;
    }
}