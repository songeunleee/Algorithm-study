import java.util.*;
class Solution {
    static int dx[] ={0,1,0,-1};
    static int dy[] = {1,0,-1,0};
    static int visited[][];
    public int solution(int[][] maps) {
        
         visited = new int[maps.length][maps[0].length];
        int answer = 0;
        
        BFS(maps,0,0);
        
        answer = visited[maps.length-1][maps[0].length-1];
        
		if(answer ==0 ){
            answer =-1;
        }
        
        return answer;         
        
       
    } 
    public void BFS(int[][] maps, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i,j});
        visited[i][j] = 1;
        while(!q.isEmpty()){
            int now[] = q.poll();
            for(int k=0;k<4;k++){
                int x = now[0]+dx[k];
                int y = now[1]+dy[k];
               if(x>=0 && y>=0&&x<maps.length&&y<maps[0].length){
      				
                   if(maps[x][y]==1 && visited[x][y]==0){
                       visited[x][y] = visited[now[0]][now[1]]+1;
                       q.add(new int[]{x,y});
                   }
               }
            }
        }
        
        }
}