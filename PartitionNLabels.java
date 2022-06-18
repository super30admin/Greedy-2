//TC : O(N)
//SC : O(1) hashmap space ignore bec at max 26 char can be there so taken as constant space
class Solution {
    public List<Integer> partitionLabels(String s) {
        if(s==null || s.length()==0) return new ArrayList();

        HashMap<Character, Integer> charIndex = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            charIndex.put(s.charAt(i),i);
        }
        int start = 0;
        int end = charIndex.get(s.charAt(0));
        List<Integer> result = new ArrayList<>();
        if(end == start)
        {
            result.add(end-start+1);
            start = end+1;
        }
        for(int i=1;i<n;i++)
        {
            char c = s.charAt(i);
            if(charIndex.get(s.charAt(i))>end)
            {
                end=charIndex.get(s.charAt(i));
            }

            if(end == i)
            {
                result.add(end-start+1);
                start = end+1;
            }
        }
        return result;
    }
}