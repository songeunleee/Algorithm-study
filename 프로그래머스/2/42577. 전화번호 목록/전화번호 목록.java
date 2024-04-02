import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String s : phone_book){
            map.put(s,0);
        }
        
        for(int i = 0; i<phone_book.length;i++){
            for(int j =0;j<phone_book[i].length();j++){
                String temp = phone_book[i].substring(0,j);
                if(map.containsKey(temp)){
                    answer = false;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}