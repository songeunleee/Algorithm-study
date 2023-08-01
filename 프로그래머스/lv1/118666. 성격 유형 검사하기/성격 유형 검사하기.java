import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<survey.length;i++){
           if(choices[i] == 1 ){
               if(map.containsKey(survey[i].charAt(0))){
                  map.put(survey[i].charAt(0),3 + map.get(survey[i].charAt(0))); 
               }  else {
                   map.put(survey[i].charAt(0),3);
               }
           }else if(choices[i] == 2 ){
              if(map.containsKey(survey[i].charAt(0))){
                  map.put(survey[i].charAt(0),2 + map.get(survey[i].charAt(0))); 
               }  else {
                   map.put(survey[i].charAt(0),2);
               }
           }else if(choices[i] == 3){
              if(map.containsKey(survey[i].charAt(0))){
                  map.put(survey[i].charAt(0),1 + map.get(survey[i].charAt(0))); 
               }  else {
                   map.put(survey[i].charAt(0),1);
               }
           }else if(choices[i] == 5){
                if(map.containsKey(survey[i].charAt(1))){
                  map.put(survey[i].charAt(1),1 + map.get(survey[i].charAt(1))); 
               }  else {
                   map.put(survey[i].charAt(1),1);
               }
           }else if(choices[i] == 6 ){
                if(map.containsKey(survey[i].charAt(1))){
                  map.put(survey[i].charAt(1),2+ map.get(survey[i].charAt(1))); 
               }  else {
                   map.put(survey[i].charAt(1),2);
               }
           }else if(choices[i] == 7 ){
               if(map.containsKey(survey[i].charAt(1))){
                  map.put(survey[i].charAt(1),3+ map.get(survey[i].charAt(1))); 
               }  else {
                   map.put(survey[i].charAt(1),3);
               }
           }
        }
        
        System.out.println(map);
                 
        
        
      if(map.containsKey('R') && map.containsKey('T')){
           if(map.get('R')<map.get('T')){
                answer += "T";   
           }else { 
                answer += "R";
           }  
      }else if(!map.containsKey('R') && map.containsKey('T')){
           answer += "T";        
      }else{
           answer += "R"; 
      } 
    
        
         if(map.containsKey('C') && map.containsKey('F')){
           if(map.get('C')<map.get('F')){
                answer += "F";   
           }else { 
                answer += "C";
           }  
      }else if(!map.containsKey('C') && map.containsKey('F')){
           answer += "F";        
      }else{
           answer += "C"; 
      } 
        
         if(map.containsKey('J') && map.containsKey('M')){
           if(map.get('J')<map.get('M')){
                answer += "M";   
           }else { 
                answer += "J";
           }  
      }else if(!map.containsKey('J') && map.containsKey('M')){
           answer += "M";        
      }else{
           answer += "J"; 
      } 
        
         if(map.containsKey('A') && map.containsKey('N')){
           if(map.get('A')<map.get('N')){
                answer += "N";   
           }else { 
                answer += "A";
           }  
      }else if(!map.containsKey('A') && map.containsKey('N')){
           answer += "N";        
      }else{
           answer += "A"; 
      } 
        

        
        return answer;
    }
}