import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<Integer> server = new LinkedList<Integer>();
        
        for (int i=0; i<players.length; i++){
            int expansionServer = players[i] / m; // 증설해야 하는 서버 수
            
            // 반납되어야 하는 시간 확인 후 빼주기
            while(!server.isEmpty() && server.peek() <= i){
                server.poll();
            }
            
            
            if(expansionServer > server.size()) {
                int count = expansionServer-server.size();
                for (int n=0; n< count; n++){
                    server.add(i+k);
                    answer ++;
                }
            }
            System.out.println(i+"시간 : queue => "+server + " 서버 개수= "+server.size() +" expansionServer= "+ expansionServer);
        }
        
        
        return answer;
    }
}