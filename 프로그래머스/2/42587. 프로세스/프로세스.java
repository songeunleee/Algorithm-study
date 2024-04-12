import java.util.*;
class Solution {
     int max = 0;
    public int solution(int[] priorities, int location) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =0;i<priorities.length;i++){
            arr.add(priorities[i]);
            map.put(i,priorities[i]);
            q.add(i);
        }
        
        
       // max(q,priorities);
        Collections.sort(arr,Collections.reverseOrder());
      //  System.out.println(arr);
        int maxI = 0;
        while(!q.isEmpty()){
            max = arr.get(maxI);
            int now = q.poll();
            if(priorities[now] < max) q.add(now);
            else if(priorities[now] == max){
              
              answer++;
                maxI++;
              if(now == location) return answer;
            } 
                
        }
        
        return answer;
    }
    
    void max(Queue<Integer> q, int[] priorities){
          while(!q.isEmpty()){
              if(max<priorities[q.peek()]) max = priorities[q.poll()];
              else q.poll();
          }
        
         
        
    }
    
}