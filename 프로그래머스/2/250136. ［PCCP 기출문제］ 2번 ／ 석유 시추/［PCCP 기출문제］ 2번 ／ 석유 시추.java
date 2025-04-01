import java.util.*;
class Solution {
    // 이해가 안되서 다른 사람들 코드 분석 및 클론 코딩
    // 시추관의 위치마다 석유 양을 저장할 list
    private static List<Integer> oilquality = new ArrayList<>();
    // 석유 id를 저장할 list
    private static List<Set<Integer>> way = new ArrayList<>();
    // oil id
    private static int oilindex =2; // 0과 1은 이미 사용중(석유 없음, 있음)
    private static int m = 0; // 열 너비
    private static int n = 0; // 행 너비
    public int solution(int[][] land) {
        int answer =0;
        n = land.length; 
        m = land[0].length;
        
        oilquality.add(0); 
        oilquality.add(0);

        // 각 열에 대해 초기화
        for (int i = 0; i < m; i++) {
            way.add(new HashSet<>());
        }
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(land[i][j] == 1){
                    oilquality.add(0);
                    checkOilVolume(land, i, j);
                    oilindex++;
                }
            }
        }
        
        for (int i=0; i<m; i++){
            int sum=0;
            Set<Integer> wayOil = way.get(i);
            for (int wayoilindex : wayOil){
                sum+=oilquality.get(wayoilindex);
            }
            answer = Math.max(sum, answer);
        }
        return answer;
    }
    
    private static void checkOilVolume(int[][] land, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            if(x<0 || x>=n || y<0 || y>=m || land[x][y] != 1) continue;
            
            land[x][y] = oilindex;
            
            oilquality.set(oilindex, oilquality.get(oilindex) +1 );
            way.get(y).add(oilindex);
            
            queue.add(new int[]{x-1, y});
            queue.add(new int[]{x+1, y});
            queue.add(new int[]{x, y-1});
            queue.add(new int[]{x, y+1});
        }
    }
    
}