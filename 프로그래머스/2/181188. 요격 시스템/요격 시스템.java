import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {
            return o1[1] - o2[1];
        }); // 정렬
        
        int missile=-1;
        for (int[] tg : targets){
            if(missile == -1){
                answer++;
                missile = tg[1]-1; // 미사일 요격 구간
                continue;
            }
            
            if(missile >= tg[0] && missile < tg[1]) continue;
            missile=tg[1]-1;
            answer++;
        }
        
            
        
        return answer;
    }
}