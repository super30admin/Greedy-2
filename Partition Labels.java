//Time complexity:O(n)
//space complexity:O(n)

class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character,Integer> map=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
            map.put(ch,i);
        }
        int start=0;
        int end=0;
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
            end=Math.max(end,map.get(ch));
            if(i==end)
            {
                result.add(end-start+1);
                start=end+1;
            }
            
        }
        return result;
        
    }
}
