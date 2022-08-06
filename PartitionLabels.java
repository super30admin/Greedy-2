//TC- O(n)
//SC- O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() < 0)return result;
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i) , i);
        }
        int end = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            int lastIndexOfChar = map.get(s.charAt(i));
            end = Math.max(end, lastIndexOfChar);
            if(i == end){
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
