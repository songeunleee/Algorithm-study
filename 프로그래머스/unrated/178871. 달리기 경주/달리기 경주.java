import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<Integer,String> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        
        
        for(int i=0;i<players.length;i++){
            map1.put(i,players[i]);
            map2.put(players[i],i);
        }
        
        for(int i =0;i<callings.length;i++){
            int runnerRank = map2.get(callings[i]);
            String runner = map1.get(runnerRank);
            
            String front = map1.get(runnerRank-1);
            
            
            map1.put(runnerRank-1,runner);
            map1.put(runnerRank,front);
            
            map2.put(runner,runnerRank-1);
            map2.put(front,runnerRank);
            
            
            
        }
        
        for(int i=0;i<players.length;i++){
            answer[i] = map1.get(i);
        }
        
        return answer;

        }    
}