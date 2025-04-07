import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = 0, y = 0;
        int height = park.length;
        int width = park[0].length();
        int[][] route = new int[height][width];

        // route 초기화 및 시작 위치 저장
        for (int i = 0; i < height; i++) {
            char[] row = park[i].toCharArray();
            for (int j = 0; j < width; j++) {
                if (row[j] == 'X') {
                    route[i][j] = 1; // 장애물
                } else {
                    route[i][j] = 0; // 산책 가능
                }
                if (row[j] == 'S') {
                    x = j;
                    y = i;
                }
            }
        }

        for (String r : routes) {
            String[] temp = r.split(" ");
            String dir = temp[0];
            int num = Integer.parseInt(temp[1]);
            boolean isBlocked = false;
            int nx = x;
            int ny = y;

            // 이동 방향별 delta 설정
            int dx = 0, dy = 0;
            switch (dir) {
                case "E": dx = 1; break;
                case "W": dx = -1; break;
                case "N": dy = -1; break;
                case "S": dy = 1; break;
            }

            // 이동 거리만큼 검사
            for (int i = 1; i <= num; i++) {
                int tx = x + dx * i;
                int ty = y + dy * i;

                // 범위 초과
                if (tx < 0 || ty < 0 || tx >= width || ty >= height) {
                    isBlocked = true;
                    break;
                }

                // 장애물
                if (route[ty][tx] == 1) {
                    isBlocked = true;
                    break;
                }
            }

            // 정상적으로 이동 가능한 경우만 위치 갱신
            if (!isBlocked) {
                x += dx * num;
                y += dy * num;
            }
        }

        return new int[]{y, x};
    }
}
