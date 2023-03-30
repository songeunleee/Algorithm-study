class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minX = 50;
        int minY = 50;
        int maxX = 0;
        int maxY = 0;
        for(int i =0;i<wallpaper.length;i++){
            
            for(int j=0;j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    if(minX>i){
                        minX = i;
                    }
                    if(minY > j ){
                        minY = j;
                    }
                    if(maxX<i){
                        maxX = i;
                    }
                    if(maxY < j ){
                        maxY = j;
                    }
                }
            }
        }
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX+1;
        answer[3] = maxY+1;
        return answer;
    }
}