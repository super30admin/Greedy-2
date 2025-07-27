// TC : O(N) Iterate over the string twice which is 2N
// SC : O(1) 26 spaces only

// Approach : 
// store the last index of every available letter in the string.
// Using the start and end iterate over the string again and check the ends if the i equals end then that set of integers can have a partition
// Then update the start to end+1 or i+1
// Add the difference of the end and start +1 to the integer list

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char x = s.charAt(i);
            arr[x - 'a'] = i;
        }
        for (int i = 0; i < n; ++i) {
            char x = s.charAt(i);
            end = Math.max(end, arr[x - 'a']);
            if(i == end){
                result.add(end-start + 1);
                start = end+1;
            }
        }

        return result;
    }
}
