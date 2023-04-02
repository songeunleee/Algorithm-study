class Solution {
    static boolean prime[];
    public int solution(int left, int right) {
        int answer = 0;
       
        
        
        for(int i = left;i<=right;i++){
            
            if(era(i)%2==0) answer+=i;
            else answer-=i;
        }
        return answer;
        
    }
    
    static int era(int n){
       int cnt = 0;
        
        for(int i=1 ;i*i<=n;i++){
            if(i*i==n) cnt++;
            else if(n%i==0) cnt+=2;
        }
       return cnt ;
    }
}