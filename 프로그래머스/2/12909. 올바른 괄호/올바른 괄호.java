import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Stack<Character> st = new Stack<>();
       
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else {
                if(st.isEmpty()) return false;
                else st.pop();
            }
        }
        if(st.isEmpty()) answer = true;
        
        return answer;
    }
}