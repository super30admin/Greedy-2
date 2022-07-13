TC: O(n)
SC:O(1)
stored the end index of each character in a hashmap.
traversed the given string and do the parttion when the index and the end value from the map matches.
update the start point accordingly


class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer>map = new HashMap<>();
        List<Integer>li = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,i);
        }
        int end=0,start=0;
        for(int i=0;i<s.length();i++){
             char c = s.charAt(i);
             end = Math.max(end,map.get(c));
             if(i==end){
                 li.add(end-start+1);
                 start = i+1;
             }
        }
        return li;
    }
}