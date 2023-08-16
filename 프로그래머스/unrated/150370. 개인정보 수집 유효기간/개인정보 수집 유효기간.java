import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
          map.put(terms[i].charAt(0), Integer.parseInt(terms[i].substring(2)));
        }

        String[] today_arr = today.split("\\.");
        int[] today_arr_int = new int[today_arr.length];
        for (int i = 0; i < today_arr_int.length; i++) {
          today_arr_int[i] = Integer.parseInt(today_arr[i]);
        }

        for (int i = 0; i < privacies.length; i++) {
          String[] date_and_type = privacies[i].split(" ");
          String[] date_arr = date_and_type[0].split("\\.");
          int[] date_arr_int = new int[today_arr.length];
          for (int j = 0; j < today_arr_int.length; j++) {
            date_arr_int[j] = Integer.parseInt(date_arr[j]);
          }
          char type = date_and_type[1].charAt(0);

          date_arr_int[1] += map.get(type);

          if (date_arr_int[1] % 12 == 0) {
            date_arr_int[0] += date_arr_int[1] / 12 - 1;
            date_arr_int[1] =  12;
          } else {
            date_arr_int[0] += date_arr_int[1] / 12;
            date_arr_int[1] =  date_arr_int[1] % 12;
          }

          if (today_arr_int[0] > date_arr_int[0]) {
            list.add(i + 1);
            continue;
          } else if (today_arr_int[0] < date_arr_int[0]) {
            continue;
          } else if (today_arr_int[0] == date_arr_int[0]) {
            if (today_arr_int[1] > date_arr_int[1]) {
              list.add(i + 1);
              continue;
            } else if (today_arr_int[1] < date_arr_int[1]) {
              continue;
            } else if (today_arr_int[1] >= date_arr_int[1]) {
              if (today_arr_int[2] >= date_arr_int[2]) {
                list.add(i + 1);
                continue;
              } else if (today_arr_int[1] < date_arr_int[1]) {
                continue;
              }
            }
          }
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}

/*
참고 할 답안 : 년월일을 굳이 각각 따질 필요가 없다!!
    class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> answer = new ArrayList<>();
            Map<String, Integer> termMap = new HashMap<>();
            int date = getDate(today);
    
            for (String s : terms) {
                String[] term = s.split(" ");
    
                termMap.put(term[0], Integer.parseInt(term[1]));
            }
            for (int i = 0; i < privacies.length; i++) {
                String[] privacy = privacies[i].split(" ");
    
                if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                    answer.add(i + 1);
                }
            }
            return answer.stream().mapToInt(integer -> integer).toArray();
        }
    
        private int getDate(String today) {
            String[] date = today.split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);
            return (year * 12 * 28) + (month * 28) + day;
        }
    }
*/
