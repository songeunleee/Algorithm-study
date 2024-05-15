class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int longer;
        int shorter;
        if(sides[0] > sides[1]){
          longer = sides[0];
          shorter = sides[1];  
        } else {
            longer = sides[1];
            shorter = sides[0];
        }
        
        int i = longer - shorter + 1;
        while(longer<shorter + i){
            if(i>longer) break;
            i++;
            answer++;
        }
        
        int j = longer + 1;
        
        while(j < shorter + longer){
            
            if(shorter + longer < j) break;
            
            j++;
            answer++;
            
        }
        
        
        return answer;
    }
}