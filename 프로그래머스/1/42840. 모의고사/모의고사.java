import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> array = new ArrayList<>();
        int[] arr = new int[3];
        int[] one = {1,2,3,4,5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i =0;i<answers.length;i++){
            if(answers[i] == one[i%one.length]){
                arr[0]++;
            }
            if(answers[i] == two[i%two.length]){
                arr[1]++;
            }
            if(answers[i] == three[i%three.length]){
                arr[2]++;
            }
        }
        int max = 0;
        for(int i = 0;i < 3;i++){
            max = Math.max(max,arr[i]);
        }
        
        for(int i = 0;i < 3;i++){
            if(max==arr[i]){
                array.add(i+1);
            }
        }
        
        return array;
    }
}