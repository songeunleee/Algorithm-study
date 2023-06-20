import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<score.length;i++){
            
         q.add(score[i]);
            if(q.size()>k) q.poll();
            
           arr.add(q.peek());
            
        }
        int []answer = new int[arr.size()];
        int n=0;
    	for(int i:arr){
            answer[n] = i;
            n++;
        }
        return answer;
    }
}