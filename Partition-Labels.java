// Time complexity: o(n)
// Space Complexity: o(n)
// leetcode: yes

// Idea:
// find the last index of the each character and store it in an arraymap
// Iterate through the string a character's last occuring instance would be the last index of current set. 
// If we meet the criteria where the last value equals the iterated character, we add the length of current partition to the arraylist and reset the first pointer to the current last index's next value

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        
        for(int i=0;i<S.length();i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        List<Integer> resultList = new ArrayList<Integer>();
        int last = 0; int first = 0;
        for(int i=0;i<S.length();i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if(last == i) {
                resultList.add(last - first + 1);
                first = last + 1;
            }
        }
        return resultList;
    }
}