import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 일단 사전순으로 정렬
        Arrays.sort(strings);
        // comparator 넣어서 정렬
        Arrays.sort(strings, new SortByIdx(n));
        return strings;
    }
    
    static class SortByIdx implements Comparator<String> {
        private int idx;

        public SortByIdx(int idx) {
          this.idx = idx;
        }

        @Override
        public int compare(String o1, String o2) {
          return o1.charAt(idx) - o2.charAt(idx);
        }
    }
}