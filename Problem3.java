//Time Complexity: O(n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem3 {

    public List<Integer> partitionLabels(String s) {
        
        if(s == null|| s.length() == 0)
            return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int start =0, end =0;
        
        for(int i =0; i <n; i++)
        {
            char c = s.charAt(i);
            map.put(c,i);
        }
        
        for(int i =0; i <n; i++)
        {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            
            if(i == end)
            {
               int p = end - start + 1;
               result.add(p);
                start = end + 1;
            }
        }
        return result;
    }
}
