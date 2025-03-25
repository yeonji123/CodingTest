import java.util.Arrays; 


class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        // 이중 배열에 데이터를 넣어줌
        // 이중 배열에 높이 계산 : 배수이면 높이만큼, 나머지가 있으면 +1
        // 왼쪽에서 시작할지 말지 확인하는 boolean 값 -> 반대라면 더해서 빼기/더하기 진행
        int heightbox = n/w;
        if (n%w != 0) heightbox++;
        int x = 0;
        int y = 0;
        int numx=0;
        int numy=0;
        boolean reverse = false;
        int[][] box = new int[heightbox][w];
        System.out.println(x + "," + y + "," +heightbox);
        
        // 박스 채우기
        for (int i=1; i<=n; i++){
            box[y][x] = i;
            if(i==num){
                numx=x;
                numy=y;
            }
            if (reverse){ // 오른쪽부터 시작한 경우 뒤에서 넣어줘야 함
                if(x==0){
                    reverse = false;
                    y++;
                }else {
                    x--;
                }
            } else {
                if(x == w-1) {
                    reverse=true;
                    y++;
                }else {
                    x++;
                }
            }
        }
        
        
        // 꺼내야 하는 박스 개수 찾기
        System.out.println(numx + "," + numy );
        while(numy<heightbox){
            if (box[numy][numx] != 0){
                answer++;
            }
            numy++;
        }
        
        return answer;
    }
}