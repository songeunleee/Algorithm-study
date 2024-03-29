import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        A = new ArrayList[n];
        for(int i=0;i<n;i++){
            A[i] = new ArrayList<>();
        }
        for(int i =0; i<computers.length;i++){
            for(int j =0;j<computers[0].length;j++){
                if(i==j) continue;
                if(computers[i][j] == 1){
                   A[i].add(j);
                   A[j].add(i);
                }
            }
        }
        int count = 0;
        visited = new boolean[n];
        for(int i =0;i<n;i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        
        return count;
    }
    
    void DFS(int v){
        visited[v] = true;
        for(int i : A[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}