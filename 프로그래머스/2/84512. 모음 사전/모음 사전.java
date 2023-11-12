// 스스로 해결 못함
// 참고 : [(Java) 프로그래머스 - 모음사전](https://rovictory.tistory.com/112)

import java.util.ArrayList;
import java.util.List;
class Solution {
    static String[] arr;
    static List<String> list;
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        // 완전탐색 메서드 호출
        recursion(word, "", 0);
        
        // 선형 탐색
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    // 완전탐색 메서드
    static void recursion(String word, String str, int depth) {
        list.add(str);
        
        if(depth == 5) {
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            recursion(word, str + arr[i], depth + 1);
        }
    }
}

// 참고 : [[프로그래머스]level 2: 모음사전_Java(위클리 5주차)](https://arinnh.tistory.com/86)

/*

풀이 1)
저는 'A', 'E', 'I', 'O', 'U' 로 만들 수 있는 모든 조합을 list에 넣고 사전순으로 정렬한 다음 indexOf를 이용해서 순서를 찾았습니다.
모든 경우의 수가 얼마 안된다고 생각해서 간단하게 생각하고 풀었는데, 다 풀고나서 보니 통과는 했는데 시간이 오래 걸렸더라고요. 그래서 다시 생각해보니 경우의 수를 잘못 생각했었습니다.

import java.util.ArrayList;
import java.util.Collections;
class Solution {
    static char[] alphabet= {'A','E','I','O','U'};
    static ArrayList<String> list;
    
    public int solution(String word) {
        list= new ArrayList<>();
        int answer = 0;
        
        combination(0, "");
        Collections.sort(list);
        answer= list.indexOf(word)+1;
        
        return answer;
    }
    
    public void combination(int index, String str){
        if(index>=5) return;
        for(int i=0; i<alphabet.length; i++){
            list.add(str+alphabet[i]);
            combination(index+1, str+alphabet[i]);
        }
    }//comb
}

*/

/*

풀이 2)

총 5+25+125+625+3125= 3905개 인데,
가장 먼저, 각 알파벳으로 시작할 수 있는 단어는 각각 781개
=> a로 시작하는 단어는 781개

그렇다면 e로 시작하는 단어는 앞에 a로 시작하는 단어 뒤에 나올테니까 적어도 781 다음부터 겠죠?
자릿수에 따라 781 / 156 / 31 / 6 / 1 이므로, 주어진 word를 한글자씩 쪼개서 자릿수 별로 answer에 더해주면 됩니다.
그래서 이 원리로 코드를 다시 짜보았습니다.

class Solution {
    
    public int solution(String word) {
        int answer = 0;
        int total= 3905;
        String aeiou="AEIOU";
        
        for(String str: word.split("")){
            //781, 156, 31, 6, 1
            total/= 5;
            answer+= total*aeiou.indexOf(str)+1;
        }
        
        return answer;
    }
}

*/