class Solution {
    public int solution(int n) {
        int answer = 0;
        String t = "";
        while(n>0){
             t += n%3 + "";  
            n = n/3;
        }
        System.out.println(t);
        for(int i =0;i<t.length();i++){
           answer +=  (t.charAt(i) -'0') * Math.pow(3,t.length()-1-i);
           
        }
        return answer;
    }
}