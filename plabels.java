
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s.length()==0 || s==null)
        {
            return new ArrayList<>();
        }
        HashMap<Character, Integer> map= new HashMap<>();
        List<Integer> res= new ArrayList<>();
        int start=0;
        int end=0;
        for(int i=0; i<s.length(); i++)
        {
            char c= s.charAt(i);
            map.put(c,i);
        }
        for(int j=0; j<s.length(); j++)
        {
            char c= s.charAt(j);
            if(map.containsKey(c))
            {
                end= Math.max(end,map.get(c));
            }
            if(j==end)
            {
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }
}