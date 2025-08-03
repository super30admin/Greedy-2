class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>output = new ArrayList<>();
        //hashmap for last occurence of each character in string
        HashMap<Character , Integer>map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // update last occurrence of character
            map.put(ch, i);
        }
        // parition the string using two pointers
        int start = 0;
        int end = 0;
        //start at index 0 and put the initial partition end at its last occurrence. Then, as you increment the pointer, if that pointer’s last occurrence is within the current partition end, it’s fine; otherwise, you extend the partition. So the maximum extended position will be the end of the first partition
        for(int i = 0 ; i < s.length();i++){
            char ch = s.charAt(i);
            end = Math.max(end , map.get(ch));
            if(i == end){
                output.add(end - start +1);
                start = i+1;
                
            }
        }
        return output;

        
    }
}