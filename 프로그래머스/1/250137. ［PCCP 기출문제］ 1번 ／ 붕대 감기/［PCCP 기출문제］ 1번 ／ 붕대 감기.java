class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int endTime = attacks[attacks.length - 1][0];
        int attackNum = 0;
        int healTime = 0;
        int maxHealth = health;
        boolean isDead = false;

        while (time++ < endTime) {
          if (time == attacks[attackNum][0]) {
            health -= attacks[attackNum][1];
            attackNum++;
            healTime = 0;

            if (health <= 0) {
              isDead = true;
              break;
            }
          } else {
            health = health + bandage[1] > maxHealth ? maxHealth : health + bandage[1];
            healTime++;
            if (healTime == bandage[0]) {
              health = health + bandage[2] > maxHealth ? maxHealth : health + bandage[2];
              healTime = 0;
            }
          }
        }

        if (isDead) {
          return -1;
        } else {
          return health;
        }
    }
}