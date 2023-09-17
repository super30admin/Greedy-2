import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = s.length()-1; i>=0; i--){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }
        }
        List<Integer> list =  new ArrayList<>();
        int start=0, end = 0;
        for(int i=0; i< s.length(); i++){
            end = Math.max(end, map.get(s.charAt(i)));
            if(i==end){
                list.add(end-start+1);
                start = end+1;
            }
        }


        return list;
    }
}
