// Time Complexity : O(n)
// Space Complexity : O(1) atmost 26 characters
// Method used : Greedy

class Solution {
    public List<Integer> partitionLabels(String s) {
        
        if(s == null || s.length() == 0) return new ArrayList();

        // This map will keep track of the character and it's last occurence index in the string
        HashMap<Character, Integer> map = new HashMap();

        for(int i = 0; i < s.length(); i++) map.put(s.charAt(i), i);

        // Initially my start and end would be 0. Basicalyy these decide the size of the partition
        int start = 0, end = 0;

        List<Integer> result = new ArrayList();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            // We take maximum because assume we have a string ababcbac. Firstly my end will be at index 8, but when I am dealing
            // with character b it's end is at index 5 which is < 8. We don't want to make our partition small. So consider 
            // maximum end value
            end = Math.max(end, map.get(c));

            // This means that all the last occurences of the characters are with in the partition
            if(i == end)
            {
                result.add(end - start + 1);

                // Change the start value
                start = end + 1;
            }
        }

        return result;
    }
}