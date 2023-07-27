import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < a.length(); i++) {
            if ('a' <= a.charAt(i) && a.charAt(i) <= 'z')
                sb.append((a.charAt(i) + "").toUpperCase());
            else 
                sb.append((a.charAt(i) + "").toLowerCase());
        }
        
        System.out.println(sb.toString());
    }
}