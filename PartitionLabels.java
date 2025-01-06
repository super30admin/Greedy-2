class Solution {
    public List<Integer> partitionLabels(String s) {
        //HashMap<Character,Integer> map= new HashMap<>();
        int [] map= new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map[c-'a']=i;
        }
        int start=0,end=0;
        List<Integer> result= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            end=Math.max(end,map[c-'a']);
            if(i == end){
                result.add(end-start+1);
                start=end+1;
            }
        }

        return result;
    }
}