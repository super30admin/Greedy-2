class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int map[] = new int[26];
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
           map[ch-'a'] =i;

        }
        int start =0;
        int end =0;
        for(int i=0;i<s.length();i++)
        {
             char ch = s.charAt(i);
             end = Math.max(end, map[ch-'a']);
             if(i==end)
             {
                res.add(end-start+1);
                start =i+1;
             }
        }
        return res;
    }
}


//Time Complexity: O(n), where n is the length of the string s.

//Space Complexity: O(n), where n is the length of the string s.

