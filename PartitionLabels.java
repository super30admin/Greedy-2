// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        //find the last indices for all the characters
        int[] lastIndices = new int[26];
        for(int i=0; i < S.length(); i++){
            lastIndices[S.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();
        //iterate through the string to find partitions
        for(int i=0; i < S.length(); i++){
            //see end index of a character and compare with end variable to take max
            //take max because we want largest partition as possible
            end = Math.max(end, lastIndices[S.charAt(i) - 'a']);
            //if current index is equal to end index then we found partition
            if(i == end){
                //add length of partition to result
                result.add(i - start + 1);
                //update the start variable
                start = i+1;
            }
        }

        return result;
    }
}