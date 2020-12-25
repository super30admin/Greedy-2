// Time Complexity : O(n), where n is the size of the String (exactly O(2n), O(n) to find the last occurence of each character, 
                        // O(n), for creating the partitions)
// Space Complexity : O(1), constant space used, (hashMap with maximum 26 charcters)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain English
//1. create a hashMap of last occurences of each character in the String
//2. create 2 pointers (start and last , both at 0th index). Iterate over the string and place last at the index which is maximum of
        //current last and the chaacter's last occurence (this is a window).
//3. Whenever i reaches at last pointer, ,meanining you found 1 partition (with all the unique characters in the cuurent window,
        //present only in this window), so record the length of this window , add it to the result and place start to last's next
        //index (to search for other such partitions)
//return the result

// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> partitionLabels(String S) {
        //List to return the result
        List<Integer> result = new ArrayList<>();
        //hashMap to store the last occurence of each character in the String
        Map<Character, Integer> map = new HashMap<>();
        
        //fill the map with last occurence of each character
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            map.put(c, i);
        }
        
        //start and end of current partition
        int start = 0;
        int last = 0;
        //iterate over the String to create the partitions
        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            //check the character in the map and calculate the last index
            last = Math.max(last, map.get(c));
            //if i is at last, you got 1 partition
            if(i == last){
                int size = last - start +1;
                result.add(size);
                //reset start to last + 1
                start = last+1;
            }
        }
        return result;
    }
}