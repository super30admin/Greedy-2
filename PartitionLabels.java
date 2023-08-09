// TC = O(n), SC = O(1) -- as only 26 characters hence hashmap memory negligible

class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=s.length()-1;i>=0;i--){ // Putting the last occurence index of each element
            char c = s.charAt(i);
            map.putIfAbsent(c,i);
        }
        int start = 0; int end = 0;
        List<Integer> result = new ArrayList<>();
        for(int i=start;i<s.length();i++){
            char c = s.charAt(i); 
            end = Math.max(end,map.get(c));
            if(i==end){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;

    }
}