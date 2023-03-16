class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String temp[] = my_string.split(" ");
        int sum = Integer.parseInt(temp[0]);
        for(int i =0;i<temp.length;i++){
            if(temp[i].equals("+")){
                sum = sum+Integer.parseInt(temp[i+1]);
            }else if(temp[i].equals("-")){
			 sum = sum-Integer.parseInt(temp[i+1]);
            }
        }
        return sum;
    }
}