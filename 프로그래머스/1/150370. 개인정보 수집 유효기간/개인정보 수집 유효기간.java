import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
      // 1. 오늘 날짜를 연, 월, 일로 나누기
      String[] ymd = today.split("\\.");
      int todayYear = Integer.parseInt(ymd[0]);
      int todayMonth = Integer.parseInt(ymd[1]);
      int todayDay = Integer.parseInt(ymd[2]);
      // 1-1. 오늘 날짜 총 일수 계산
      int totalDaysToday = todayYear * 12 * 28 + todayMonth * 28 + todayDay;

      // 2. 약관 종류와 유효기간을 Map에 저장
      Map<String, Integer> termMap = new HashMap<>();
      for (String term : terms) {
        String[] termInfo = term.split(" ");
        String termType = termInfo[0];
        String termPeriod = termInfo[1];
        termMap.put(termType, Integer.parseInt(termPeriod));
      }

      // 3. 유효기간이 지난 개인정보를 저장할 리스트
      List<Integer> expiredPrivacies = new ArrayList<>();
      // 4. 유효기간이 지난 개인정보를 찾기
      for (int i = 0; i < privacies.length; i++) {
        String[] privacyInfo = privacies[i].split(" ");
        String[] privacyYmd = privacyInfo[0].split("\\.");
        int privacyYear = Integer.parseInt(privacyYmd[0]);
        int privacyMonth = Integer.parseInt(privacyYmd[1]);
        int privacyDay = Integer.parseInt(privacyYmd[2]);

        String privacyType = privacyInfo[1];
        Integer privacyPeriod = termMap.get(privacyType);

        if (privacyPeriod != null) {
          // 계약 체결일 총 일수 계산
          int totalDaysPrivacy = privacyYear * 12 * 28 + privacyMonth * 28 + privacyDay;
          // 계약 체결일 + 유효기간 총 일수 계산
          int expirationDate = totalDaysPrivacy + (privacyPeriod * 28);
          // 유효기간이 지난 개인정보인지 확인
          if (totalDaysToday >= expirationDate) {
            expiredPrivacies.add(i + 1); // 1-indexed
          }
        }
      }

      return expiredPrivacies.stream().mapToInt(i -> i).toArray();
    }
  }