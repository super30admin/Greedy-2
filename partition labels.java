//Time complexity:- 0(n)
//space complexity:- O(n)
//did it run on leetcode:- Yes.
//approach is given in comments.


class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result=new ArrayList<>();
        HashMap<Character,Integer> cache=new HashMap<>();
        for(int i=0;i<s.length();i++){
            cache.put(s.charAt(i),i); // storing end indices of where last time appeared characters in hashmap.
        }
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,cache.get(s.charAt(i)));
            if(end==i){                    //updations of end and start pointers for adding length of parts
                                           
                result.add(end-start+1);
                start=end+1;
            }
        }
            
            
            
            
        
        return result;
    }
}