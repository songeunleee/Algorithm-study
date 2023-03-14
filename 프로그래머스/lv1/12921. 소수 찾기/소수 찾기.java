class Solution {
    boolean prime[];
    public int solution(int n) {
        
        int answer = 0;
        elasto(n);
        for(int i=0;i<prime.length;i++){
            if(!prime[i]) answer++;
        }
        return answer;
    }
    void elasto(int n){
        prime = new boolean [n+1];
        
        prime[0] = prime[1] = true;
        
        for(int i=2;i<=Math.sqrt(prime.length);i++){
            if(prime[i] ==true){
                continue;
            }
            
            for(int j=i*i;j<prime.length;j=j+i){
                prime[j] = true;
            }
        }
    }
}