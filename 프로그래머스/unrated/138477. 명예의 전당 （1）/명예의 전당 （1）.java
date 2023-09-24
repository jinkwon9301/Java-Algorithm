import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] result = new int[score.length];
        int idx = 0;
        RankList rankList = new RankList();

        for (int i : score) {
          rankList.add(i);
          result[idx++] = rankList.getScore(k);
        }
        
        return result;
    }
    
    static class RankList {
        private List<Integer> list = new LinkedList<>();

        public List getList() {
          return list;
        }

        public void add(int num) {
          if (list.size() == 0) {
            list.add(num);
          }
          else if (list.size() == 1) {
            if (num < list.get(0)) {
              list.add(0, num);
            } else {
              list.add(1, num);
            }
          }
          else if (list.size() == 2) {
            if (num < list.get(0)) {
              list.add(0, num);
            } else if (list.get(1) < num) {
              list.add(2, num);
            } else {
              list.add(1, num);
            }
          }
          else if (list.get(list.size() - 1) < num) {
            list.add(num);
          }
          else if (num < list.get(0)) {
            list.add(0, num);
          }
          else {
            int left = 0;
            int right = list.size() - 1;
            int half = (left + right) / 2;

            while (left != half) {
              if (num < list.get(half)) {
                right = half;
                half = (left + right) / 2;
              } else if (list.get(half) < num) {
                left = half;
                half = (left + right) / 2;
              } else {
                right = half;
                break;
              }
            }

            list.add(right, num);
          }
        }

        public int getScore(int k) {
          if (list.size() < k) {
            return list.get(0);
          } else {
            return list.get(list.size() - k);
          }
        }
    }
}