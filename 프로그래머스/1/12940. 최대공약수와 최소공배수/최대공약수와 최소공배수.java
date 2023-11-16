class Solution {
    public int[] solution(int n, int m) {
        
        int[] answer = new int[2];
        if(n>m){
            answer[0] = gcd(n,m);
            answer[1] = n*m/gcd(n,m);
        }else{
            answer[0] = gcd(m,n);
            answer[1] = n*m/gcd(m,n);
        }
        return answer;
    }
    
    int gcd(int a, int b){
        
        if(b==0) return a;
        
        return gcd(b,a%b);
    }
}