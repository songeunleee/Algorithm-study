import java.util.*;
import java.util.Map.Entry;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<>();
        
        if(cacheSize==0){
            return cities.length * 5;
        }
        
        for(int i=0;i<cities.length;i++){
            cities[i] = cities[i].toUpperCase();
        }
        
        Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        };
        
        for(int i=0;i<cities.length;i++){
            
            if(!map.containsKey(cities[i])){
                answer+=5;
                
            }else{
                map.replace(cities[i],i);
                answer++;
                continue;
            }
        
            if(map.size()<cacheSize){
                 map.put(cities[i],i);
           
            }else{
                Entry<String, Integer> minEntry = Collections.min(map.entrySet(), comparator);
                map.remove(minEntry.getKey());
                map.put(cities[i],i);
            }
                
                
            
        
        }
        
        
        
        return answer;
    }
}