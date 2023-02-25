import java.util.*;

class Solution {
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int [id_list.length];
        boolean [][] user = new boolean[id_list.length][id_list.length];
        int [] number = new int[id_list.length];
        
        for(int i =0;i<report.length;i++){
           String temp[] = report[i].split(" "); //temp 0은 신고하는사람, temp0는 신고당한사람
            int singoUser = getIndex(id_list,temp[0]);
            int singoedUser = getIndex(id_list,temp[1]);
            if(user[singoUser][singoedUser] != true) number[singoedUser]++;
            user[singoUser][singoedUser] = true;
            
        }
        
       for(int i=0;i<number.length;i++){
           if(number[i]>=k){
               for(int j =0;j<id_list.length;j++){
                   if(user[j][i] == true)
                       answer[j]++;
               }
           }
       }
        
        
        
        
        return answer;
    }
    
    static public int getIndex(String[] list, String a){
      	int index =0;
        for(int i=0;i<list.length;i++){
            if(list[i].compareTo(a)==0){
                index =i;
                break;
            }
            
        }
   return index;
    }
  
}