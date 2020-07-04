// Time Complexity : O(2n)= O(n) where n is the number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Store the last occurance of the character in a map so that we know till where my 
character is reappearing and I can finalise my length of the partition. When i reaches the end position denoting the end of the partition, it means
I can start a new partition and repeat the steps again.
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<Integer>();
        if(S == null || S.length() == 0){return result;}
        HashMap<Character, Integer> store = new HashMap<>();
        for(int i  = 0; i < S.length(); i++){   
            store.put(S.charAt(i), i);                                                              // Store the last occurance of the character
        }
        int start = 0, end = 0;
        for(int i = 0; i < S.length(); i++){
            end = Math.max(end, store.get(S.charAt(i)));                                            // Store the max ending index of the character
            if(end == S.length()-1) {
                result.add(end - start + 1);                                                        // if character is at last position, do quickly
                break;
            }
            if(i == end){                                                                           // When the index reaches the end of partition
                result.add(end - start + 1);
                start = end + 1;                                                                    // Get the length of the partition
            }
        }
        return result;
    }
}