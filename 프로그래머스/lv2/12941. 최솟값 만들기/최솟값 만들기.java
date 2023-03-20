import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> qr = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for(int i=0;i<A.length;i++){
           q.add(A[i]);
            qr.add(B[i]);
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
       
        
        for(int i =0;i<A.length;i++){
            answer = answer+ q.poll() * qr.poll();
        }

        return answer;
    }
}