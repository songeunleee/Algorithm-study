import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        int slice = score.length%m;
        
      for(int i=slice;i<score.length;i+=m){
         answer = answer+(score[i] * m);
      }
        
        
        
        return answer;
    }
}