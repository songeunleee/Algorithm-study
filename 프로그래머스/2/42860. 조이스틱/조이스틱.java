import java.util.*;

class Solution {
    public int solution(String name) {
        int UpDown = 0;
        int len = name.length();
        for(int i = 0;i<name.length();i++){
            if(name.charAt(i) < 'N')
            UpDown = UpDown + name.charAt(i) - 'A';
            
            else
            UpDown = UpDown + 'Z' - name.charAt(i) + 1; 
        }
        int LeftRight = len;
        int next = 0;
        for(int i = 0;i<name.length();i++){
           int conA = i+1;
            while(conA <len && name.charAt(conA) =='A'){
                conA++;
            }
			// 좌우이동
            LeftRight = Math.min(LeftRight, i+(len-conA)+Math.min(i,len-conA));
        }
        return UpDown + LeftRight;
        }
        
        
        
    }
    
