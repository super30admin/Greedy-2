// TC - O(n) --> 2 pass so it will be O(2n) so it will be O(n) eventually.
// SC - O(1) as our Hashmap will have at max 26 entries which is constant.
class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();

        // null check
        if (s ==null || s.length()==0) return result;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,i);
        }

        int start = 0, end =0;
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            end = Math.max(end,map.get(c));
            if(i==end){
                result.add(end-start+1);
                start = i+1;
            }
        }
        return result;
    }
}