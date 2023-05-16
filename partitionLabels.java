/*
Time Complexity - O(n) where n is the length of the string s.
Space Complexity - O(1).
 */
class Solution {
    public List<Integer> partitionLabels(String s) {

        int[] lastIndex = new int[26];
        List<Integer> result = new ArrayList<Integer>();

        if(s == null || s.length() == 0)
            return result;

        for(int i = 0; i < s.length(); i++) {
            int asciiVal = s.charAt(i) - 'a';
            lastIndex[asciiVal] = i;
        }

        int curPartitionStart = 0, curPartitionEnd = 0;
        for(int i = 0; i < s.length(); i++) {
            int asciiVal = s.charAt(i) - 'a';
            curPartitionEnd = Math.max(curPartitionEnd, lastIndex[asciiVal]);
            if(i == curPartitionEnd || curPartitionEnd == s.length()) {
                result.add(curPartitionEnd - curPartitionStart + 1);
                curPartitionStart = curPartitionEnd + 1;
                if(curPartitionEnd == s.length())
                    break;
            }
        }
        return result;
    }
}
