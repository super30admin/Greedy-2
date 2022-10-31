//Time O(N)
//Space O(N)
public List<Integer> partitionLabels(String s) {

        int[] lastIndices = new int[26];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<s.length(); i++)
            lastIndices[s.charAt(i)-'a'] = i;

        int lastIndex = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            int index = lastIndices[s.charAt(i)-'a'];
            count++;
            if(index>lastIndex)
                lastIndex = index;

            if(i==lastIndex) {
                list.add(count);
                lastIndex=i;
                count=0;
            }
        }

        return list;
        
    }