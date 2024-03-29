class Solution {
    int answer = 0;
    boolean visited[];
    public int solution(String begin, String target, String[] words) {
    visited = new boolean[words.length];
       dfs(words,begin,target,0);
        
        
        return answer;
    }
    
    void dfs(String[] words, String begin, String target, int depth){
        
       if (begin.equals(target)) {
            answer = depth;
            return;
        }
        for(int i =0;i<words.length;i++){
            if(visited[i]) continue;
            if(compare(begin,words[i])){
                visited[i] = true;
                dfs(words,words[i],target,depth+1);
                visited[i] = false;
            }
        }
       
    }

    
    boolean compare(String s1, String s2){
        int count = 0;
        for(int i = 0; i<s1.length() ;i++){
            if(s1.charAt(i) == s2.charAt(i)){
                count++;
            }
        }
        
        if(s1.length() - count == 1) return true;
        else return false;
            
    }
    
}

    