class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int number = 0;
        for(int i = 1;i<=num;i++){
            number = number + i;
        }
           
        int count = 0;
        
        if(number<total){
             while(number < total){
            number = number + num;
            count++;
        }
        }else{
             while(number > total){
            number = number - num;
            count--;
        }
        }
       
        
      
        
        int first = count + 1;
        
        
        for(int i =0;i<num;i++){
            answer[i] = first + i;
        }
        
        
        return answer;
    }
}