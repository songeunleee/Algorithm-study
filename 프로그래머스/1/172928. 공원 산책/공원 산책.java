class Solution {
    int x=0;
    int y=0;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];  
        
        for(int i =0;i<park.length;i++){
            for(int j =0;j<park[0].length();j++){
                if(park[i].charAt(j) == 'S'){
                    x = i;
                    y = j;
                }
            }
        }
      
        
        for(int i =0;i<routes.length;i++){
            char dir = routes[i].charAt(0);
            int num = routes[i].charAt(2) - '0';
            
            move(dir,num,park);
        }
        
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
    
    void move(char dir, int num, String[] park){
        if(dir == 'E'){
            int c =0;
            for(int i = 0;i<num;i++){
                    if(y+1 >= park[0].length()){
                        y = y-c;
                        return;  
                    } 
                    if(park[x].charAt(y+1) == 'X' ){
                        y = y - c;
                        return;
                    } 
                c++;
                y++;
            } 
           
        }
        if(dir == 'W'){
            int c =0;
            for(int i=0;i<num;i++){
                    if(y-1<0) {
                        y = y + c;
                        return;   
                    }
                    if(park[x].charAt(y-1) == 'X'){
                        y = y + c;
                        return;
                    }
                c++;
                y--;
            } 
            
        }
        if(dir == 'N'){
            int c =0;
            for(int i=0;i<num;i++){
                    if(x-1 <0){
                    x = x +c;
                        return;
                    } 
                    if(park[x-1].charAt(y) == 'X'){
                     
                  x = x + c;
                        return;  
                    } 
                c++;
                x--;    
            } 
            
        }
        if(dir == 'S'){
            int c =0;
            for(int i=0;i<num;i++){
                
                    if(x+1 >= park.length){
                        x = x -c;
                        return;  
                    } 
                    if(park[x+1].charAt(y) =='X'){
                        x= x-c;
                        return;
                    } 
            c++;    
            x++;
            } 
            
        }
    }
}