import java.util.*;
import java.util.Comparator;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        // ext : code, date 중 하나
        // sort_by : maximum, remain 중 하나
        // data에서 ext값이 val_ext갑소바 작은 데이터만 뽑고 sort_by에 맞춰서 정렬해야한다
        String[] list = {"code", "date", "maximum", "remain"};
        // int extIndex = ext == "code" ? 0:1;
        // int sortIndex = sort_by == "maximum"? 2 : 3;
        
        ArrayList<int[]> beforeSort = new ArrayList<int[]>();
        
        for (int i=0; i<data.length; i++){
            if(data[i][Arrays.asList(list).indexOf(ext)] < val_ext){
                beforeSort.add(data[i]);
            }
        }

        beforeSort.sort(Comparator.comparingInt(a -> a[Arrays.asList(list).indexOf(sort_by)]));
        answer=beforeSort.toArray(int[][]::new);
        
        return answer;
    }
}