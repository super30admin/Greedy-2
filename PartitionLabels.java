//time o(n)
//space o(1)
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if(S == null || S.length() == 0)
            return res;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        
        int end = 0;
        int start = 0;
        for(int i=0; i<S.length(); i++) {
            char ch = S.charAt(i);
            end = Math.max(end, map.get(ch));
            if(i == end) {
                res.add(end-start+1);
                start = end+1;
            }
        }
        return res;
    }
}