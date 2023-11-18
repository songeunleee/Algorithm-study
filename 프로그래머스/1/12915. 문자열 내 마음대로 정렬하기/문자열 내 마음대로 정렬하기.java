import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        Arrays.sort(strings);
        Arrays.sort(strings,(e1,e2)->{
            return e1.charAt(n) - e2.charAt(n);
        });
    
        
        return strings;
    }
}