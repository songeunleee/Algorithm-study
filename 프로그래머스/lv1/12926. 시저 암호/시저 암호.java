class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
         for(int i =0;i<s.length();i++){
             if(s.charAt(i)  + n > 'Z' && s.charAt(i)   < 'a' ) {
             answer += (char)( s.charAt(i)+n -26);  
              
                 continue;
                
             } if(s.charAt(i)  + n > 'z' ) {
             answer += (char)( s.charAt(i)+n -26);  
                 continue;
                
             } if(s.charAt(i) == ' ' ){
                 answer += ' ';
                 continue;
             }
                 answer += (char)(s.charAt(i) + n);
                   
           
       }
        
        return answer;
    }
}