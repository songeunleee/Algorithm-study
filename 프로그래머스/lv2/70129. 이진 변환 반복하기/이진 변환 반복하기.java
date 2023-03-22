class Solution {
    public int[] solution(String s) {
       
     
        int zero = 0;
        int bNum = 1;
        int len = 0;
        
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='0') zero++;
            else len++;
        }
        while(len>1){
            String binary = Integer.toBinaryString(len);
            bNum++;
            len=0;
            for(int i =0;i<binary.length();i++){
            if(binary.charAt(i)=='0') zero++;
            else len++;
        }
        }
      
         int[] answer = {bNum,zero};
        return answer;
        
    }
}