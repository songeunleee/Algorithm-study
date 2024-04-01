import java.util.*;
class Solution {
    boolean visited[];
     int answer = -1;
    public int solution(int k, int[][] dungeons) {
       
        visited = new boolean[dungeons.length];
        
        dfs(dungeons,k,0);
        
        
        return answer;
    }
    
    void dfs(int[][] arr, int k, int idx){
        
        for(int i = 0; i<arr.length;i++){
            if(!visited[i] && arr[i][0]<=k){
            visited[i] = true;    
            dfs(arr, k - arr[i][1], idx+1);  
            visited[i] = false;
            }
        }
        
       answer = Math.max(answer,idx);
    }
}