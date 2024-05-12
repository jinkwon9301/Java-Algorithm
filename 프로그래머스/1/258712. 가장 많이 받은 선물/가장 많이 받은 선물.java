import java.util.*;

class Solution {
    static Map<Integer, Integer> giftIndex = new HashMap<>();
    static Map<String, Integer> friendNum = new HashMap<>();
    static int[][] histoty;
    static int maxGetGifts = 0;
    static int getGifts = 0;
    
    public int solution(String[] friends, String[] gifts) {
        for (int i = 0; i < friends.length; i++) {
          giftIndex.put(i, 0);
          friendNum.put(friends[i], i);
        }

        histoty = new int[friends.length][friends.length];

        for (int i = 0; i < gifts.length; i++) {
          String from = gifts[i].split(" ")[0];
          String to = gifts[i].split(" ")[1];

          Integer fromNum = friendNum.get(from);
          Integer toNum = friendNum.get(to);

          giftIndex.put(fromNum, giftIndex.get(fromNum) + 1);
          giftIndex.put(toNum, giftIndex.get(toNum) - 1);

          histoty[fromNum][toNum]++;
        }

        for (int i = 0; i < friends.length; i++) {
          for (int j = 0; j < friends.length; j++) {
            if (i != j) {
              if (histoty[i][j] > histoty[j][i] || histoty[i][j] == histoty[j][i] && giftIndex.get(i) > giftIndex.get(j)) {
                getGifts++;
              }
            }
          }
          if (maxGetGifts < getGifts) {
            maxGetGifts = getGifts;
          }
          getGifts = 0;
        }

        return maxGetGifts;
    }
}