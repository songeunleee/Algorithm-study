import java.util.*;
class Solution {
    boolean visited[];
    int count;
    public int solution(int[] cards) {
        int answer = 0;
        int arr[] = new int[cards.length];
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0;i<cards.length;i++){
                visited = new boolean[cards.length];
                dfs(i,cards);
                arr[i] = count;
        }
        
        for(int i =0;i<arr.length;i++){
            if(arr[i] == cards.length){
              return 0;  
            } 
            set.add(arr[i]);
        }
        
        ArrayList<Integer> setarr = new ArrayList<>(set);
        Collections.sort(setarr);
        
        if(setarr.size() == 1) answer = setarr.get(0) * setarr.get(0);
        else {
            answer = setarr.get(setarr.size()-1) * setarr.get(setarr.size()-2);
        }
        
        
        
        return answer;
    }
    
    void dfs(int idx, int[] cards){
        count = 0;
        if(visited[cards[idx]-1] == true){
            
            for(int i =0;i<visited.length;i++){
                if(visited[i]) count++;
            }
            return;
        }
        if(!visited[cards[idx]-1]){
            visited[cards[idx]-1] = true;
            dfs(cards[idx]-1,cards);   
        }
    }
}