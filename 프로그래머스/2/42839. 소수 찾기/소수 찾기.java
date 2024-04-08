import java.util.*;
class Solution {
    static boolean[] isPrime;
    static boolean[] visited;
    int answer = 0;
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        
        
        visited = new boolean[numbers.length()];
        
        dfs(0,numbers,"");
        
        Integer[] arr = set.toArray(new Integer[0]);
        
        for(int i =0;i<arr.length;i++){
            if(arr[i] == 0) continue;
            isPrime(arr[i]);
            if(isPrime[arr[i]]) answer++;
        }
        
        return answer;
    }
    
    void dfs(int depth, String numbers,String result){
        if(depth<=numbers.length() && depth>=1){
                set.add(Integer.parseInt(result));
            }  
        
        
        for(int i = 0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1,numbers,result+numbers.charAt(i));
                visited[i] = false;
            }
            
        }
    }
    
    void isPrime(int n){
        isPrime = new boolean[n+1];
        for(int i=0;i<isPrime.length;i++){
            isPrime[i] = true;
        }
        
        isPrime[0] = isPrime[1] = false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(isPrime[i]){
                for(int j = i*i;j<=n;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        
    }
}