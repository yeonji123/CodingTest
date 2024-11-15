function solution(friends, gifts) {
    var answer = 0;
    
    // 준사람, 받은 사람 중 몇번 받았는지 확인
    let givetake =[];
    let giftcount = []
    for (var i=0; i<friends.length; i++){
        let list =[]
        for (var j=0; j<friends.length; j++){
            list.push(0)
        }
        givetake.push(list)
        
        giftcount.push(0)
    }
    
    
    for (var gift of gifts){
        // 받은 사람, 준 사람
        let giveindex = freindsIndex(gift.split(" ")[0])
        let takeindex = freindsIndex(gift.split(" ")[1])

        // 선물을 준것과 받은 것을 입력
        givetake[giveindex][takeindex] += 1
        
        // 선물 지수 알아보기
        giftcount[giveindex]+=1
        giftcount[takeindex]-=1
        
    }
    console.log("givetake", givetake)
    console.log("giftcount", giftcount)
    
    for (var i=0; i<friends.length; i++){
        let num = 0;
        for (var j=0; j<friends.length; j++){
            if (i === j) continue;
            
            if (givetake[i][j] > givetake[j][i] ||
                     (givetake[i][j] == givetake[j][i] && giftcount[i] > giftcount[j])) {
                        num++;
            }
        }
        if(answer < num){
            answer = num
        }
    }
    
    
    
    
    
    // 주거나 받은 사람을 아는 함수
    function freindsIndex(who){
        for (var i = 0; i < friends.length; i++){
            if(friends[i] === who) return i
        }
    }
    
    return answer;
}