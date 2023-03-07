import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        if(s.charAt(0)==')') return false;
		Stack<Character> st = new Stack<>(); 
        for(int i=0; i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }else {
                if(!st.isEmpty()){
                st.pop();    
                }
                
            }
        }
        
        if(st.isEmpty()){
            answer = true;
        }else
            answer = false;
        
        System.out.println("Hello Java");

        return answer;
    }
}