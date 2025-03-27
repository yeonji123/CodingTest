class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        // 출근 인정 시간 구하기
        // timelogs의 값 중에서 넘은 시간이 있는지 확인 
        // startday 확인하기 금요일인 경우는 주말인 1,2 인덱스는 무시?
        // 없으면 answer+1
        
        int admitTime=0;
        int admithun=0;
        
        for (int i = 0; i < schedules.length; i++) {
            boolean success=true;
            int day = startday;
            
            admitTime = schedules[i] + 10; // 출근 인정 시간 계산
            if (admitTime%100 >= 60) {
                admithun = admitTime/100;
                admitTime = admithun*100 + 100 + (admitTime%100)-60;
            }
            
            for (int j=0; j<timelogs[i].length; j++){
                // 주말의 인덱스는 무시해야 함 
                // startday=1이면, 월요일 -> 인덱스 5,6 무시
                // startday=2이면, 화요일 -> 인덱스 4,5 무시
                // startday=3이면, 수요일 -> 인덱스 3,4 무시
                if(day%7 == 0 || day%7 == 6) {
                    day++;
                    continue;
                }
                // 평일
                if  (timelogs[i][j] > admitTime) {
                    success=false;
                    break;
                }
                day++;
                System.out.println("i= "+i+ " j= "+j+" admitTime= "+admitTime+" startday= "+startday);
            }
            if (success) answer++;
        }
        
        return answer;
    }
}