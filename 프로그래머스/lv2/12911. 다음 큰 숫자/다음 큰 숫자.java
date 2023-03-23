class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean cat = true;
        int num = n;
        while(cat){
            num++;
            if(one(Integer.toBinaryString(n),Integer.toBinaryString(num))){
             cat = false;
                answer = num;
            }
        }
        
        return answer;
    }
    
     static boolean one (String Nbinary, String binary){
         int Nnum = 0;
         int num =0;
         for(int i=0; i<Nbinary.length();i++){
             if(Nbinary.charAt(i)=='1') Nnum++;
             
         }
        
         for(int i =0; i<binary.length();i++){
             if(binary.charAt(i)=='1') num++;
         }
         if(Nnum==num){
            
             return true;
         }
         
        return false;
    }
}