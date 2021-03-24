//TC O(N)
//SC O(N)

// idea  is to check that chars occurs last in the given string , that is single partition
// we need to returns the no of partition like that.

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;
        
        int j = 0, partCount = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']); // we are taking math.max becauase we need to find the lenth of maximum substring where a char is appears at most one part.
            if (i == j) { // reset the partition , find the new partition.
                ans.add(i - partCount + 1);
                partCount = i + 1;
            }
        }
        return ans;
    }
}
