/*
  [프로그래머스] 이모티콘 할인행사

  user는 자신이 설정한 할인율 이상인 이모티콘을 구매한다.
  이모티콘을 구매한 비용이 유저의 기준가 이상되면 이모티콘 플러스 서비스에 가입한다.
  이모티콘을 구매한 비용이 유저의 기준가 미만이면 이모티콘 플러스 서비스에 가입하지 않고 이모티콘을 구매한다.
  이모티콘 할인율은 이모티콘마다 다를 수 있으며 10%, 20%, 30%, 40% 중 하나이다.
  이모티콘 할인율을 정할 때,
  1. 이모티콘 플러스 서비스에 가입한 사람의 수와
  2. 이모티콘을 구매한 비용의 합을 최대화하는 것이 목표이다.
  1번이 우선 2번은 차선.
  이모티콘 플러스 서비스에 가입한 사람의 수와 이모티콘을 구매한 비용의 합을 반환한다.

  📚 완전탐색[브루트포스], DFS(Permutation), 시뮬레이션
 */

/*
  * DFS를 사용한 완전탐색을 해도 4^7 = 16,384 * 100(유저수) * 7(이모티콘)로 충분히 가능하다.

  1. 할인율 조합 만들기 (DFS or 재귀)
  각 이모티콘에 대해 [10, 20, 30, 40] 중 하나 선택
  모든 조합 만들기 → 예: [30, 10], [20, 40], [40, 40] 등

  2. 각 조합마다 시뮬레이션 실행
  모든 유저에 대해:
  유저가 지정한 비율 이상 할인된 이모티콘만 구매
  총합이 기준 가격 이상이면 → 구매 취소 + 서비스 가입
  아니면 → 그대로 구매

  3. 가입자 수 & 매출 계산
  모든 유저에 대해 위 기준으로 계산 후
  (가입자 수, 판매금액) 반환

  4. 가장 가입자 수가 많은 조합을 고름
  동일한 가입자 수일 경우 → 판매금액이 더 큰 조합 선택
*/


class Solution {
    int maxJoin = 0;
    int maxSales = 0;
    int[] discounts = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
      dfs(0, new int[emoticons.length], users, emoticons);
      System.out.println("maxJoin = " + maxJoin);
      System.out.println("maxSales = " + maxSales);
      return new int[]{maxJoin, maxSales};
    }

    void dfs(int idx, int[] discountSet, int[][] users, int[] emoticons) {
      if (idx == emoticons.length) {
        simulate(discountSet, users, emoticons);
        return;
      }

      for (int d : discounts) {
        discountSet[idx] = d;
        dfs(idx + 1, discountSet, users, emoticons);
      }
    }

    void simulate(int[] discountSet, int[][] users, int[] emoticons) {
      int join = 0;
      int sales = 0;

      for (int[] user : users) {
        int rate = user[0];
        int limit = user[1];
        int total = 0;

        for (int i = 0; i < emoticons.length; i++) {
          if (discountSet[i] >= rate) {
            int price = emoticons[i] * (100 - discountSet[i]) / 100;
            total += price;
          }
        }

        if (total >= limit) {
          join++;
        } else {
          sales += total;
        }
      }

      if (join > maxJoin || (join == maxJoin && sales > maxSales)) {
        maxJoin = join;
        maxSales = sales;
      }
    }
  }
