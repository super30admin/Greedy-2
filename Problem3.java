// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem3 {
    //TC:O(N)
    //SC:O(1)
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> endIndexMap = new HashMap<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            //find last occurence of each character
            endIndexMap.put(c,i);
        }

        int start = 0;
        int end = 0;

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            end = Math.max(end,endIndexMap.get(c));
            if(end == i){
                //start a new partition
                result.add(end-start+1);
                start = end+1;
            }

        }
        return result;
    }
}
