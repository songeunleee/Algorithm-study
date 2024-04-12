import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =0;i<priorities.length;i++){
            arr.add(priorities[i]);
            q.add(i);
        }
        
        Collections.sort(arr,Collections.reverseOrder());
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
    
}