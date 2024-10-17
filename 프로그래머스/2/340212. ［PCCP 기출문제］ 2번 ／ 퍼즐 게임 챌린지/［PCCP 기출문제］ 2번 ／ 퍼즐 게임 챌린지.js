// diffs : 난이도
// 현재 퍼즐의 소요시간 : time_cr
// 이전 퍼즐의 소요시간 : time_prev
// 숙련도 : level
function solution(diffs, times, limit) {
    
    
    // 해석봄
    // 투 포인터 설정
    let left = 1
    let right = 100_001 // Math.max(...diffs) 하면 런타임 에러 뜸
    
    while(left <= right) {
        // 이진 탐색을 위한 mid 선언
        const mid = Math.floor((left + right) / 2)
        if(canSolve(mid)) right = mid - 1 
        else left = mid + 1
    }
    
    
    function canSolve(level){
        var time = 0
        for (var i = 0; i<diffs.length; i++){
            // 숙련도가 난이도보다 높으면 시간만 추가
            if (diffs[i] - level <= 0) time += times[i] 
            else if (diffs[i] - level > 0){ // 숙련도가 난이도보다 작으면 틀린 것으로 추정
                time += (times[i-1] + times[i]) * (diffs[i] - level) + times[i]
            }
            // console.log(level_temp, diffs[i], times[i], level_temp, time)
        }
        return time <= limit
    }
    
    return left
    
    /*
    // 초기 코드
    var level = 0;
    // 숙련도와 난이도로 비교하기 때문에 
    // 가장 높은 난이도보다 숙련도가 같거나 낮을때마 반복함
    var max_level = Math.max(...diffs);
    // level을 ++하여 확인
    while(level < max_level){
        var level_temp = level+1
        var time = 0
        // console.log(level_temp, time)
        for (var i = 0; i<diffs.length; i++){
            // 숙련도가 난이도보다 높으면 시간만 추가
            if (diffs[i] - level_temp <= 0) time += times[i] 
            else if (diffs[i] - level_temp > 0){ // 숙련도가 난이도보다 작으면 틀린 것으로 추정
                time += (times[i-1] + times[i]) * (diffs[i] - level_temp) + times[i]
            }
            // console.log(level_temp, diffs[i], times[i], level_temp, time)
        }
        level = level_temp
        if(time <= limit) break;
    }
    
    return level;
    */
}