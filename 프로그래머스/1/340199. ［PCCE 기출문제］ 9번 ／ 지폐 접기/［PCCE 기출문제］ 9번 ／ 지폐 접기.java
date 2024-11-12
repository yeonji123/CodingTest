class Solution {
    // wallet : 지갑의 가로, 세로
    // bill : 지폐의 가로 세로
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletSmall = 0;
        int walletLarge = 0;
        int billSmall = 0;
        int billLarge = 0;
        
        if(wallet[0]>wallet[1]) { 
            walletLarge = wallet[0];
            walletSmall = wallet[1];
        } else {
            walletLarge=wallet[1];
            walletSmall = wallet[0];
        }
        
        if(bill[0]>bill[1]) { 
            billLarge = bill[0];
            billSmall = bill[1];
        } else {
            billLarge=bill[1];
            billSmall = bill[0];
        }
        System.out.println(walletSmall + ", " + walletLarge + "," + billSmall +","+  billLarge);
        
        // for문으로 길이를 비교하며 지갑보다 지폐의 길이가 짧아야 한다
        while(true){
            if(walletLarge < billLarge || walletSmall < billSmall) { // 지폐의 큰값이 지값의 큰값보다 크면 접읍
                billLarge /= 2;
                answer ++;
            }
            if(billLarge < billSmall){ // 정수 두자리수 이기 때문에 지폐의 큰값과 작은 값을 비교
                int temp = billLarge;
                billLarge = billSmall;
                billSmall = temp;
            }
            
            if(walletSmall >= billSmall && walletLarge >= billLarge){
                break;
            }
        }
        System.out.print("anwer = "+ answer);
        
        return answer;
    }
}