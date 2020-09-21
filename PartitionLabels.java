//TC: O(n)
//SC: O(1)
class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0) return null;
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            map.put(c, i);
        }
        List<Integer> res = new ArrayList();
        int start = 0; int end = 0;
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            end = Math.max(end, map.get(c));
            if(end == i){
                res.add(end-start+1);
                start = end+1;
            }
        }
        return res;
    }
}
