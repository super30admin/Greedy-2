// Time Complexity: O(n)
// Space Complexity: O(1) as constant 26 alphabets
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0)
            return result;
        
        // create a map of last occurence of every char 
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length(); i ++)
        {
            map.put(s.charAt(i), i);
        }
        
        int start = 0 ,end = 0;
        // for all characters in string find last occurence
        for(int i= 0 ; i < s.length(); i ++)
        {
            char c = s.charAt(i);
            // check last occurence c between start && end
            end = Math.max(end, map.get(c));
            
            if(i == end) // max possible end
            {
                result.add(end- start + 1);
                start = end+1; // next partition
            }
        }
        
        return result;
    }
}
