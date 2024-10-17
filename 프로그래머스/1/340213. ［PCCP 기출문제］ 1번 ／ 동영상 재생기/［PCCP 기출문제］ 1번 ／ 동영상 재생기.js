function solution(video_len, pos, op_start, op_end, commands) {
    var answer = '';
    var time = 0
    
    // 시간을 숫자로 전환
    let video_len_int = video_len.split(":")[0] * 60 + parseInt(video_len.split(":")[1])
    let pos_int = pos.split(":")[0] * 60 + parseInt(pos.split(":")[1])
    let op_start_int = op_start.split(":")[0] * 60 + parseInt(op_start.split(":")[1])
    let op_end_int = op_end.split(":")[0] * 60 + parseInt(op_end.split(":")[1])
    console.log(video_len_int, pos_int, op_start_int, op_end_int)
    
    time = pos_int
    for (var i=0; i<commands.length; i++){
        if (op_start_int <= time && time <= op_end_int) time = op_end_int
        
        if (commands[i] === "next"){ // 10초 후로 이동
            time+=10
        } else { // 10초 전으로 이동
            time-=10
        }
        
        if (time<0) time = 0 // 시간은 0이상이어야 한다.
        // 오프닝 중이면 오프닝 끝난 위치로 이동
        if (op_start_int <= time && time <= op_end_int) time = op_end_int
        if (time > video_len_int) time = video_len_int
        console.log(time)
    }
    var min = Math.floor(time/60)
    var sec = Math.floor(time - min*60)
    answer = min.toString().padStart(2,"0")+":"+ sec.toString().padStart(2,"0")
    console.log(time, min, sec, answer)
    
    
    return answer;
}