class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        
        boolean part1 = true;
        boolean part2 = true;
        
        if (!x1 && !x2) part1 = false;
        if (!x3 && !x4) part2 = false;
        
        return (part1 && part2) ? true : false;
        
    }
}