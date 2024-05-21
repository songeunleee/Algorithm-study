class Solution {
     static int answer = 0;
    static boolean[] visited;
    public int solution(String[] babbling) {
       
        String[] bal = {"aya","ye","woo","ma"};
        visited = new boolean[4];
        dfs(bal,babbling,0,"");
        
        return answer;
    }
    
    void dfs(String[] bal, String[] babbling,int depth,String baleum){
        if(depth<=4){
            System.out.println(baleum);
            for(int i =0;i<babbling.length;i++){
                if(baleum.equals(babbling[i])){
                    answer++;
                }
            }
        }
        for(int i =0;i<bal.length;i++){
            if(!visited[i]){
            visited[i] = true;
            dfs(bal,babbling,depth+1,baleum+bal[i]);  
                visited[i] = false;
            }
            
        }
    }
}