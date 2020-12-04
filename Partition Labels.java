//Time Complexity-O(n)
//Space -O(n)
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer>output=new ArrayList();
        if(S==null||S.length()==0)
        {
            return output;
        }
        HashMap<Character,Integer>map=new HashMap();
        for(int i=0;i<S.length();i++)
        {
            map.put(S.charAt(i),i);
        }
        int start=0;
        int end=0;
        int i=0;
        while(i<S.length())
        {            
            end=Math.max(end,map.get(S.charAt(i)));
            if(i==end)
            {
                output.add(end-start+1);
                start=i+1;
            }
            i++;            
        }
        return output;
    }
}