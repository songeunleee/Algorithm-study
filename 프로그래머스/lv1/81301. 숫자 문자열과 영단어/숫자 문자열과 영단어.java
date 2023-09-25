class Solution {
    public int solution(String s) {
        String answer = "";
        String temp = "";
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i) >= '0' && s.charAt(i)<='9'){
                answer += s.charAt(i);
                
            }else{
                temp += s.charAt(i); 
                
                if(strToInt(temp)!=-1){
                answer += strToInt(temp);
                temp="";
                    
                }
                
                
            }
            
            
        }
        return Integer.parseInt(answer);
    }
    
    public int strToInt(String temp){
        
        if(temp.equals("zero"))
            return 0;
        if(temp.equals("one"))
            return 1;
        if(temp.equals("two"))
            return 2;
        if(temp.equals("three"))
            return 3;
        if(temp.equals("four"))
            return 4;
        if(temp.equals("five"))
            return 5;
        if(temp.equals("six"))
            return 6;
        if(temp.equals("seven"))
            return 7;
        if(temp.equals("eight"))
            return 8;
        if(temp.equals("nine"))
            return 9;
        
            return -1;
    }
    
}