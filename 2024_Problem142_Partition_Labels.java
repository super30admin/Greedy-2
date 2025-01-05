//763. Partition Labels - https://leetcode.com/problems/partition-labels/
//Time Complexity: O(2n) ~ O(n)
//Space Complexity: O(26) ~ O(1) : map can be made for utmost 26 characters

class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        //create map and store last indexes of the char "c"
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            map.put(c, i); //put and update
        }
        //start and pointers to get the partition
        int start=0, end=0;
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            //for each "c", max index will give the current partition
            //therefore Math.max(end, map.get)
            end = Math.max(end, map.get(c));
            if(i == end){
                result.add(end - start + 1);
                //restart start pointer
                start = i+1; //or end+1
            }
        }
        return result;
    }
}