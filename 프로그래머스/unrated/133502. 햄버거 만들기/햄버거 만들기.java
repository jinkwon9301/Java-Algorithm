class Solution {
    public int solution(int[] ingredient) {
        
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
        
//         StringBuffer sb = new StringBuffer();
//         int count = 0;
//         for (int i = 0; i < ingredient.length; i++) {
//           sb.append(ingredient[i]);
//           if (ingredient[i] == 1 && sb.length() >= 4 && sb.substring(sb.length() - 4, sb.length()).toString().equals("1231")) {
//             count++;
//             sb = new StringBuffer(sb.substring(0, sb.length() - 4));
//           }
//         }
        
//         return count;
    }
}