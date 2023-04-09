class Solution {
    public String solution(int[] numbers, String hand) {
        
        String answer = "";
       int left = 10;
        int right = 12;
   
        
        for(int i =0 ;i<numbers.length;i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                left = numbers[i];
                answer+="L";
            }else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                right = numbers[i];
                answer+="R";
            }else{
               
                if(numbers[i]==0) numbers[i] = 11;
                
                int rh = Math.abs(right-numbers[i])/3 + Math.abs(right-numbers[i])%3;
                int lh = Math.abs(left-numbers[i])/3 + Math.abs(left-numbers[i])%3;
                
                
                if(rh > lh){
                    answer+="L";
                    left = numbers[i];
                    
                }else if (rh <lh){
                    answer+="R";
                    right = numbers[i];
                }else{
                    if(hand.equals("right")){
                        answer+="R";
                    right = numbers[i];
                        
                    }else{
                        answer+="L";
                    left = numbers[i];
                    }
                }
                
                
                
            }
        }
        
        return answer;
    }
}