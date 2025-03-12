// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
  public List<Integer> partitionLabels(String s) {
    List<Integer> result = new ArrayList<>();
    int[] lastOccurence = new int[26];

    // Calculate last Occurence
    for(int i = 0; i<s.length(); i++) {
      lastOccurence[s.charAt(i)-'a'] = i;
    }

    // Calculate Partitions
    int left = 0;
    int start = 0;
    int end = 0;

    while(left < s.length()) {
      char current = s.charAt(left);
      end = Math.max(end, lastOccurence[current-'a']);
      if(left == end) {
        result.add(end-start+1);
        start = left + 1;
      }
      left++;
    }

    return result;
  }
}