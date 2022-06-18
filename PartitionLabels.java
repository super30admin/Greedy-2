class Solution {

    // Time Complexity : 0(n) where n is the length of the string
// Space Complexity : 0(1) we don't conside space for hashmap because in any case it will hold only 26 alphabets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        HashMap<Character, Integer> map = new HashMap<>();  //A hahmap to store the last occurence of a character in the string
        List<Integer> result = new ArrayList<>();   //result to store the partition ranges
        for(int i = 0; i < s.length(); i++){    //traversing through the string
            char c = s.charAt(i);
            map.put(c, i);  //storing the last occurences of each character in the hashmap
        }
        int start = 0;  //taking the starting point of the partition as 0 initially
        int end = 0;    //taking end point of the partition as 0 initially
        for(int i = 0; i < s.length(); i++){    //iterating through the string
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));    //end will store the final occurence of the particular character in the string. Then from that point onwards, all the characters are evaluated and checked if it lies in the range of start to end or not, if the final occurence of the character in that range is greater than end, then end is reset to that particular index
            if(i == end){   //if i reached end, meaning we have our partition from start to end
                result.add(end - start + 1);    //we record our end index
                start = end + 1;    //we reset start to end + 1 as our new partition will begin from there
            }
        }
        return result;  //In the end I return the result
    }
}


