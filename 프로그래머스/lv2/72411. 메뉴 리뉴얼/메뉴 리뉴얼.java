// 내가 푼 것 아님
// 참고 : [[level2] 프로그래머스 - 메뉴 리뉴얼(JAVA)](https://jisunshine.tistory.com/146)

// 컴비네이션, dfs

import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    static String str;
    static ArrayList<String> list = new ArrayList<>();
    static int[] max;
    
    public String[] solution(String[] orders, int[] course) {
        max = new int[course.length];

        for (int i = 0; i < orders.length; i++) {

          char a[] = orders[i].toCharArray();
          Arrays.sort(a);
          str = String.copyValueOf(a);

          for (int j = 0; j < course.length; j++) {
            dfs(0, 0, course[j], "", j);
          }
        }

        for (String s : map.keySet()) {
          for (int i = 0; i < course.length; i++) {
            if (s.length() == course[i] && map.get(s) == max[i] && max[i] != 1) list.add(s);
          }
        }

        return list.stream().sorted().map(s -> s).toArray(String[]::new);
    }
    
  private static void dfs(int depth, int idx, int len, String result, int j) {

    if (depth == len) {
      map.put(result, map.getOrDefault(result, 0) + 1);
      max[j] = Math.max(max[j], map.get(result));
      return;
    }

    for (int i = idx; i < str.length(); i++) {
      dfs(depth + 1, i + 1, len, result + str.charAt(i), j);
    }
  }
}