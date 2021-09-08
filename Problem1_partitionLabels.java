// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> partitionLabels(String s) {
        
        if(s==null||s.length()==0)
            return new ArrayList<>();
        
        Map<Character,Integer> indexMap=new HashMap<>();
        
        int start=0,end=0;
        
        for(int i=0;i<s.length();i++)
        {
            indexMap.put(s.charAt(i),i);
        }
        
        List<Integer> result=new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            end=Math.max(end,indexMap.get(c));
            
            if(s.length()-1 == end)
            {
                result.add(end-start+1);
                break;
            }
            
            if(i==end)
            {
                result.add(end-start+1);
                start=i+1;
            }
        }
        
        return result;
    }
}
