class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> ans = new ArrayList<>();

        // array of indexes of last occurence of that character
        int[] arr = new int[26];

        for(int i=0 ; i<s.length() ; i++)
        {
            arr[s.charAt(i)-'a'] = i;
        }

        int farthest = 0;
        int start = 0;

        for(int i=0 ; i<s.length() ; i++)
        {

            farthest = Math.max(farthest,arr[s.charAt(i)-'a']);

            if(i==farthest)
            {
                ans.add(farthest-start+1);
                start = farthest +  1;
            }

        }

        return ans;


    }
}
