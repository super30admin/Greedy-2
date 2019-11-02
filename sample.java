// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] l = new int[26];
        for (int i = 0; i < S.length(); i++)
            l[S.charAt(i) - 'a'] = i;
        
        int start = 0, end = 0;
        List<Integer> res = new ArrayList();
        for (int i = 0; i < S.length(); i++) {
            start = Math.max(start, l[S.charAt(i) - 'a']);
            if (i == start) {
                res.add(i - end + 1);
                end = i + 1;
            }
        }
        return res;
    }
}

// Time Complexity : O(n2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] l1, int[] l2){
                return l1[0]==l2[0]?l1[1]-l2[1]:l2[0]-l1[0];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] p: people){
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][2]);
        
    }
}
