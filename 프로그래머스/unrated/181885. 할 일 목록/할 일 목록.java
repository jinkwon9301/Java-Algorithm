class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        
        int false_count = 0;
        
        for (boolean b : finished) {
            if (!b) false_count++; 
        }
        
        String[] answer = new String[false_count];
        int idx = 0;
        
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) answer[idx++] = todo_list[i];
        }
        
        return answer;
    }
}