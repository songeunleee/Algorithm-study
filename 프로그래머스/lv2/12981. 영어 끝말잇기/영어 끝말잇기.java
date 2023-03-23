import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int answer[] = {0,0};
		int idx = 0;
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for(int i = 1; i<words.length;i++){
            if(!list.contains(words[i])){
                String before = list.get(idx);  
                if(before.charAt(before.length()-1) != words[i].charAt(0)){
                    return result(i,n);
                }
                idx++;
                list.add(words[i]);
        }else{
                return result(i,n);
            }
        
        }

        return answer;
    }
    
    static int[] result(int idx, int n){
     int order = (idx / n) + 1;
        int num = (idx % n) + 1;
        return new int[] {num, order};
    }
}