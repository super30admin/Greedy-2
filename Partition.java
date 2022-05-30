// O(n) time : n length of stirng s
// O(1) space to keep data stucture last, constant space

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        
        // get last index of occurrence of each char in string
        for (int i = 0; i < s.length(); ++i){
            last[s.charAt(i) - 'a'] = i;
        }
        
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < s.length(); ++i){
            end = Math.max(end, last[s.charAt(i) - 'a']); // keep setting j to the last occurrence of character
            if (i == end){ // finally reach subset where all characters are contained, add to answer
                ans.add(i - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}