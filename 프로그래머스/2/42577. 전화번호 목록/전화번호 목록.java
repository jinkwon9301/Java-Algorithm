// 참고 : [[프로그래머스] 전화번호 목록 (해시 Lv. 2) - 자바 Java](https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%84%ED%99%94%EB%B2%88%ED%98%B8-%EB%AA%A9%EB%A1%9D-%ED%95%B4%EC%8B%9C-Lv-2-%EC%9E%90%EB%B0%94-Java)

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<String, Boolean> map = new HashMap<>();
        
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], true);
        }
        
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (map.get(phone_book[i].substring(0, j)) != null)
                    return false;
            }
        }
        
        return true;
        
    }
}