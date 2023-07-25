class Solution {
    public String solution(String my_string, int[][] queries) {
        
        for (int i = 0; i < queries.length; i++) {
            
            StringBuffer sb = new StringBuffer();
            sb.append(my_string.substring(queries[i][0], queries[i][1] + 1));
            
            my_string = my_string.substring(0, queries[i][0])
                + sb.reverse()
                + my_string.substring(queries[i][1] + 1, my_string.length());
        }
        
        return my_string;
        
    }
}