class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            map.put(c,i);
        }
        int start=0,end=0;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            end=Math.max(map.get(c),end);
            if(i==end){
                res.add(end-start+1);
                start=end+1;
            }
            
        }
        return res;
    }
}
