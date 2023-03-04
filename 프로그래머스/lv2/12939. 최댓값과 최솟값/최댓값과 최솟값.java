import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> qr = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> qm = new PriorityQueue<>();
        PriorityQueue<Integer> qmr = new PriorityQueue<>(Collections.reverseOrder());
  		//ArrayList A = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder();
      
      String[] A = s.split(" ");
       
        
       for(int i=0;i<A.length;i++){
           
           if(A[i].charAt(0) == '-'){
              System.out.println(A[i]);
              qm.offer(Integer.parseInt(A[i]));
              qmr.offer(Integer.parseInt(A[i]));
            
          }else{
              q.offer(Integer.parseInt(A[i]));
           	  qr.offer(Integer.parseInt(A[i]));
              
          }
        }
  
        if(q.isEmpty()){
            answer = qm.poll() + " "+ qmr.poll();
        }else if(qm.isEmpty()){
            answer = q.poll() + " "+ qr.poll();
        }else{
           answer = qm.poll() + " " + qr.poll();
        }
       
     
        return answer;
    }
}