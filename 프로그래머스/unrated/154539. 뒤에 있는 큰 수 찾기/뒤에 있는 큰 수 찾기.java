// 내가 푼 것 아님

// 참고 : [[프로그래머스] - 뒤에 있는 큰 수 찾기 (JAVA)](https://sasca37.tistory.com/306)

import java.util.*;

// 다른 사람의 풀이

// class Solution {
//     public int[] solution(int[] numbers) {
//         // number index 정보를 담을 Stack 생성
//         Stack<Integer> stack = new Stack<>();

//         // 정답 배열 생성
//         int[] answer = new int[numbers.length];

//         // 첫 번째 number 인덱스 stack에 push
//         stack.push(0);

//         // 두 번째 원소부터 numbers 탐색
//         for (int i = 1; i < numbers.length; i++) {
//             // 스택이 비어있지 않으면서 현재 스택이 바라보고 있는 값보다 number의 값이 크면 뒤에 있는 큰 수 해당
//             while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
//                 // 뒤에 있는 큰 수에 해당하는 모든 값 pop
//                 answer[stack.pop()] = numbers[i];
//             }
//             // 현재 인덱스 push
//             stack.push(i);
//         }
//         // 모든 index를 탐색 후 뒤에 있는 큰 수가 없는 경우 -1 
//         while (!stack.isEmpty()) {
//             answer[stack.pop()] = -1;
//         }

//         return answer;
//     }
// }

// 내 풀이

class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
          if (stack.empty()) {
            stack.push(new int[]{i, numbers[i]});
          }

          else {
            if (stack.peek()[1] >= numbers[i]) {
              stack.push(new int[]{i, numbers[i]});
            }
            else {
              while (true) {
                result[stack.pop()[0]] = numbers[i];

                if (stack.isEmpty() || stack.peek()[1] >= numbers[i]) {
                  stack.push(new int[]{i, numbers[i]});
                  break;
                }
              }
            }
          }
        }

        while (!stack.isEmpty()) {
          result[stack.pop()[0]] = -1;
        }

        return result;
    }
}