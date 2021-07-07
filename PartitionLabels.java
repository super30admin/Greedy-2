// 763.
// time - O(n)
// space - O(n)
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        //edge
        if(S == null || S.length() == 0)
        {
            return result;
        }
        
        //map to maintain the last index at which a particular char in S occurs
        HashMap<Character, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < S.length(); i++)
        {
            indexMap.put(S.charAt(i), i);
        }
        
        int start = 0; //starting of current partition
        int end = 0; //possible end of current partition
        for(int i = 0; i < S.length(); i++)
        {
            end = Math.max(end, indexMap.get(S.charAt(i))); //update end if needed
            if(i == end)
            {
                //reached end of current partition
                result.add(end - start + 1); //adding current partition size to result
                start = end + 1;
            } 
        }
        return result;
    }
}
