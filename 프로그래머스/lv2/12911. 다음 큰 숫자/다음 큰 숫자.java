class Solution {
    public int solution(int n) {
        int num = n + 1;
        int num_count_1 = 0;
        int n_count_1 = 0;
        String num_toBinary = "";
        String n_toBinary = Integer.toBinaryString(n);
        
        for (int i = 0; i < n_toBinary.length(); i++)
            if (n_toBinary.charAt(i) == '1') n_count_1++;
        
        while(true) {
            num_toBinary = Integer.toBinaryString(num);
            
            for (int i = 0; i < num_toBinary.length(); i++)
                if (num_toBinary.charAt(i) == '1') num_count_1++;
            
            if (n_count_1 == num_count_1) break;
            
            num++;
            num_count_1 = 0;
        }
        return num;
    }
}