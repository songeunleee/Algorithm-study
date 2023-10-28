class Solution {
    String answer = "";
    public String solution(String s) {
        
        
        String[] sArr = s.split("");
        int idx = 0;
        for(int i =0;i<sArr.length;i++){
             if (sArr[i].equals(" ")) {
                idx = 1;
            }
            
            answer += idx % 2 == 0 ? sArr[i].toUpperCase() : sArr[i].toLowerCase();
            idx++;
        
            
            
        }
        
        return answer;
    }
    
 
}