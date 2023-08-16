//Time: O(n)
//Space: O(n)
class Solution {

    public List<Integer> partitionLabels(String s) {

        int[] lastIndices = new int[26];
        LinkedList<Integer> partitions = new LinkedList();

        for (int i = 0; i < s.length(); i++) {

            lastIndices[s.charAt(i) - 'a'] = i;

        }

        int i = 0;

        while (i < s.length()) {
            int end = lastIndices[s.charAt(i) - 'a'];

            int j = i;

            while (j != end) {
                end = Math.max(lastIndices[s.charAt(j) - 'a'], end);
                j++;
            }
            partitions.add(j - i + 1);
            i = j + 1;
        }

        return partitions;
    }
}