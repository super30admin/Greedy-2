
// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1) since the size of the hashmap will be at most 26 (for each letter in the alphabet)

//We use greedy approach to solve this problem.
//The idea is to first store the last position of every character in a hashmap.
//Then we can iterate through the string and keep track of the maximum last position of the characters we have seen so far.
//When the current index is equal to the maximum last position, we can partition the string at that index.
//We can then add the length of the partition to the result list and update the start index for the next partition.
//Finally we can return the result list.

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        //store the last position of every character 
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,i);
        }
        List<Integer> res=new ArrayList<>();
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            end=Math.max(end,map.get(c));
            if(i==end){
                res.add(end-start+1);
                start=i+1;
            }

        }
        return res;
    }
}