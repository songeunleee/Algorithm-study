class Solution {
    public String solution(int[] food) {
        String answer = "";
        int []num = new int[food.length];
        for(int i =1;i<food.length;i++){
           
                num[i] = food[i]/2;
            
        }
        for(int i=1;i<num.length;i++){
           for(int j=0;j<num[i];j++){
               
            answer+= i + "";
               }
        }
        answer += 0 + "";
        for(int i=num.length-1;i>=1;i--){
           for(int j=0;j<num[i];j++){
               
            answer+= i + "";
               }
        }
        
        return answer;
    }
}