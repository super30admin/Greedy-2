//141.763.Partition Labels
// Time Complexity :o(n);
// Space Complexity :o(n); for map that we are maintaining
// Did this code successfully run on Leetcode :Y;
// Any problem you faced while coding this :N;

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map =new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            map.put(c,i);
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            int endofc=map.get(c);
            end=Math.max(end, endofc);
            
            if(i==end)
            {
                int cou=end-start+1;
                res.add(cou);
                start=i+1;
            }
            
        }
        return res;
    }
}

// Your code here along with comments explaining your approach
