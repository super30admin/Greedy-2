import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity : O(N)
//Space Complexity : O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        //null
        if(s.length()==0 || s == null) return result;
        //put char and its last index occured
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),i);
        }
        int start=0; int end =0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            //if end of current partition add to result indices and length
            if(end == i){
                result.add(end-start+1);
                start = i + 1;
            }
        }
        return result;
    }
}