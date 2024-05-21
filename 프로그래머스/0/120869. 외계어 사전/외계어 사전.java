import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i<dic.length;i++){
            set.clear();
            for(int j=0;j<dic[i].length();j++){
                
                int num = Arrays.asList(spell).indexOf(dic[i].charAt(j)+"");
                if(num>=0){
                    
                    set.add(num);
                   
                }
            }
            if( set.size() ==spell.length ) return 1;
        }
        
        return 2;
    }
}