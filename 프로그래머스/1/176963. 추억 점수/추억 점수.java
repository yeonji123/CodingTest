import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        // name : 사람 이름들
        // yearniing : 점수 배열
        // photo : 각 사진에 찍힌 인물의 이름
        HashMap<String, Integer> score = new HashMap<String, Integer>();
        for (int i=0; i<name.length; i++){
            score.put(name[i], yearning[i]);
            System.out.println("name[i]= "+name[i]+" yearning[i]= "+yearning[i]);
        }
        
        for (int i=0; i<photo.length; i++){
            int totalScore = 0;
            for (int j=0; j<photo[i].length; j++){
                String person = photo[i][j];
                int s = score.getOrDefault(person, 0);
                totalScore+=s;
                
            }
            System.out.println("result= "+totalScore);
            answer[i] = totalScore;
        }
        
        return answer;
    }
}