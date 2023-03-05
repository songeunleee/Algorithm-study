import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>(); 
        List<Integer> ans = new ArrayList<>(); 
        
        for(int i =0;i<progresses.length;i++){
            int day = 0;
            while(true){
                progresses[i] += speeds[i]; 
                day++;
                if(progresses[i]>=100) break;
               
                
            }
            q.offer(day);
        }
        
        while(!q.isEmpty()){
        int day = q.poll();
            int cnt = 1;
            
            while(!q.isEmpty() && day>=q.peek()){
                cnt++;
                q.poll();
            }
            
            ans.add(cnt);
            
        }
        
       
        
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}