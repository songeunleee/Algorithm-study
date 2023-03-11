import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int answer = 0;
        
        for(int i=0;i<scoville.length;i++){
            
            q.add(scoville[i]);
            
        }
        //System.out.println(q);
        
     
       
        int min=q.peek();
        while(q.size()>1&&min<K){  
            answer++;
            int a = q.poll();
            int b = q.poll();
            int num = a +b*2;
            q.add(num);
           min = q.peek();
          
        }
        if(min<K){
            answer = -1;
        }
     	
        
       
        
        System.out.println(min);
        return answer;
    }
}