class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
		int game = n/2;

        if(a>b){
            int temp = a;
            a = b;
            b=temp;
        }

        int player[] = new int[n+1];
        for(int i =1;i<=n;i++){
            player[i] = i;
        }
      
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        
        
        for(int i =1;i<player.length-1;i++){
           if( player[i]==a&&player[i+1]==b){
               if(i%2!=1) continue;
               return 1;
           }
        }
        
        while(game>0){
              System.out.println();
              
            
            answer++;
          
            for(int i = 1; i<=game;i++){
           if(player[i*2]==a || (player[i*2-1])==a){
               player[i] = a;
               
               continue;
           }else{
               player[i] = player[i*2];
           }
                if(player[i*2]==b || player[i*2-1]==b){
               player[i] = b;
           
               continue;
           }   else{
               player[i] = player[i*2];
           }
           
            
        }
      
            
              for(int i =1;i<=game;i++){
           
                 if(player[i-1]==a && player[i]==b){
                  if(i%2!=0) continue; 
                 return answer+1;
            }
            }
           
            game = game/2;
          //  System.out.println("game = "+game);
        }
        

        return answer;
    }
}