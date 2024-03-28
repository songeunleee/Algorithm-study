import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       
       ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<speeds.length;i++){
            int deploy = 0;
            if((100 - progresses[i])%speeds[i] == 0)
                deploy = (100 - progresses[i])/speeds[i];
            else
                deploy = (100 - progresses[i])/speeds[i] + 1;
            
            q.add(deploy);
            
        }
        int max = 0;
        int num =1;
        while(q.size()>1){
            if(max<q.peek()){
                max = q.poll();
            }else { 
            q.poll();
            }
            System.out.println(max);
            if(max>=q.peek()){
                num++;           
            }
            else{
            arr.add(num);
            num = 1;    
            }
        }
       arr.add(num);
        int[] answer = new int[arr.size()]; 
        for(int i = 0;i<arr.size();i++){
            answer[i] = arr.get(i);
        }
        
        
        
        return answer;
    }
}