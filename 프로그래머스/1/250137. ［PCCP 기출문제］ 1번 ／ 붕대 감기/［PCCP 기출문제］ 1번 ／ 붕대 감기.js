// bandage :  [시전 시간(t), 초당 회복량(x), 추가 회복량(y)]  
// attacks : [[공격 시간, 피해량]... ]
function solution(bandage, health, attacks) {
    var answer = 0;
    
    // 최대 체력보다 커지는 것 X
    // 현재 체력이 0이하가되면 끝 = return -1
    // attacks : 2초일 때 공격, 9초일 때 공격 ..
    // attacks가 모두 끝나면 return
    
    let second = 0
    let lastSec = lastAttackSec(attacks); // 몇초까지 돌려야 하나
    let nowHealth = health // 체력 확인 
    let recoverytime = 0 // 회복 연속 성공 변수
    
    // 마지막 공격을 받고 남은 체력을 return
    for (var i=0; i<lastSec+1; i++){
        console.log("Second : ", i)
        
        // 현재 공격 시간인지 확인
        if (isAttack(i) === 0) {
            recoverytime = recoverytime + 1
            nowHealth = addHealth(nowHealth, bandage[1])
            console.log("공격 안함 nowHealth : ", nowHealth, '연속 성공 : ', recoverytime)
        }else {
            // 회복 실패
            recoverytime = 0
            // 공격 받음
            nowHealth -= isAttack(i)
            console.log("공격함!!!!! -- nowHealth : ", nowHealth)
        }
        
        // 연속으로 체력 회복 성공 시 
        if(recoverytime === bandage[0]) {
            nowHealth = addHealth(nowHealth, bandage[2])
            console.log("체력 연속 성공 nowHealth : ", nowHealth)
            recoverytime = 0
        }
        
        // 현재 체력 값 확인
        if (nowHealth <= 0) {
            console.log("체력 없음 : ", nowHealth)
            nowHealth =-1
            break;
        }
    }
    
    
    console.log("Final nowHealth : ", nowHealth)
    return nowHealth;
    
    
    
    function addHealth(now, stamina){
        now += stamina
        if(now > health) now = health
        return now
    }
    
    // 배열에서 공격하는지 확인 후 공격력 return, 공격이 아니면 0 return 
    function isAttack(sec){
        for (var i=0; i<attacks.length; i++){
            if(sec === attacks[i][0]) return attacks[i][1]
        }
        return 0
    }
    
    
    function lastAttackSec(attacks){
        let lastSec = 0;
        
        attacks.forEach((attack) =>{
            lastSec = attack[0] > lastSec ? attack[0] : lastSec
        })
        console.log("lastAttackSec: ", lastSec)
        return lastSec
    }
}



