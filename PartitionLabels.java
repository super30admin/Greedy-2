// Greedy
//TC: O(N)
//SC: O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public List<Integer> partitionLabels(String S) {
         if ( S == null || S.length() == 0)
              return new ArrayList();
         List<Integer> result = new ArrayList();
         HashMap<Character, Integer> map = new HashMap();
         for (int i = 0 ; i < S.length(); i++)
         {
            char c = S.charAt(i);
            map.put(c, i);
         }
         int start = 0;
         int end = 0;
         for ( int i = 0 ; i < S.length(); i++)
         {
             char c = S.charAt(i);
             end = Math.max(end, map.get(c));
             if ( i == end)
             {
                 result.add(end-start+1);
                 start = i+1;
             }
         }
         return result;
    }
}
