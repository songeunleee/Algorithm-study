import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>(); 
        ArrayList<Integer> answer = new ArrayList<>();
       
        
        s.add(arr[0]);
        for(int i =1;i<arr.length;i++){
            if(s.peek()==arr[i]) continue;
            s.push(arr[i]);
        }
    
        while(!s.isEmpty()){
            answer.add(s.pop());  
           
        }
      Collections.reverse(answer);
        
         int[] result = new int [answer.size()];
        for(int i =0;i<result.length;i++){
            result[i] = answer.get(i);
        }

        return result;
    }
}