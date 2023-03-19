import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length;j++){
                if(i==j) continue;
				num.add(numbers[i] + numbers[j]);
            }
        }
    
        Collections.sort(num);
            for(int i=0;i<num.size();i++){
               
                if(!result.contains(num.get(i))){
           
               	 result.add(num.get(i));    
                }
                
            }
        System.out.println(result);
       
        
        return result.stream()
                .mapToInt(x -> x)
                .toArray();
    }
}