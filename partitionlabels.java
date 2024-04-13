// TC=O(n)
// SC=O(n)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> r = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            map.put(c , i);
        }
        int st = 0; int ed = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            ed = Math.max(ed , map.get(c));
            if( i == ed){
            r.add(ed - st + 1);
            st = i + 1;
            }
                       
        }  
        return r;
    }
}