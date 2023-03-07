import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
       int yx= 1;
        
        while(true){
            
              int yy = yellow / yx;
            
            if(yellow%yx==0&&(yx + yy) * 2 + 4 == brown){
                answer[0] = yy + 2;
                answer[1] = yx + 2;
                 System.out.println(yy + " " + yx);
                break;
            }
            yx++;
        	}
            
        
        
        return answer;
    }
}