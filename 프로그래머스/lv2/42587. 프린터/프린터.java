import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        
        
        for(int i=0;i<priorities.length;i++){
            q.add(i);
        }
        int cnt = 0;

        while(!q.isEmpty()){
            int now = q.peek();
            System.out.println(now);
            int max = 0;
            for(int i=0;i<priorities.length;i++){
               if(max<priorities[i]){
                  max =  priorities[i];
               }
                
            }
            if(max > priorities[now]){
                    q.poll();
                    q.add(now);
            }else if(max == priorities[now]){
                    q.poll();
                    cnt++;
                    priorities[now] = -1;  
                if(now == location){
                answer = cnt;
                break;
            }
           	}
            

            
            
            
             }
            
        
        
        
        return answer;
    }
}