/*
* Approach: Greedy Approach
 - Idea is to be greedy and find the last index of the seen element and make the partition till that index
 - Firstly, create a map or char array of size 26 to store the last index of the characters
 - In the second pass, iterate over the string, get the first element and set end to last index of that element
 - keep iterating and keep udating the end and once we have iterated to all the elements till the end, then thats our partition
 - TC: O(n)
 - SC: O(n)
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int end = 0;
        //start and end to get the size of the partition
        int start = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            end = Math.max(end, map.get(curr));
            //once the i reaches the end index, that means we have found our first partition, so add it to the result and update the start pointer to point to the next element
            if(i == end){
                res.add(end - start + 1);
                start = i + 1;
            } 
        }
        return res;
    }
}
