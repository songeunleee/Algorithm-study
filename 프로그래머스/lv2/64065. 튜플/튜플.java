import java.util.regex.*;
import java.util.*;
class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] temp = s.split("}");
     
        String p = "([0-9]+,?)+";
        Pattern pat = Pattern.compile(p);
        Matcher m = pat.matcher(s);
      for(int i =0;i<temp.length;i++){
          if(m.find())
          temp[i] = m.group();
      }
        
         Arrays.sort(temp, (a, b)->Integer.compare(a.length(), b.length()));
        
        for(int i =0;i<temp.length;i++){
            String t[] = temp[i].split(",");
            for(int j=0;j<t.length;j++){
                if(answer.contains(Integer.parseInt(t[j]))) continue;
                answer.add(Integer.parseInt(t[j]));
            }
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}