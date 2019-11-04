/*
The time complexity is O(N) and the space complexity is O(1) where N is the length of Strig S.

Here intuition is get the last occurence of a character and iterate till it. If you found any other characters last occurence which is
beyound the current last then change the last. After you reach the last index add the size to your list.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public List<Integer> partitionLabels(String S) {

        int[] last = new int[26];

        //Calculate the last of each character.
        for(int i=0;i<S.length();i++){
            last[S.charAt(i)-'a'] = i;
        }

        int start = 0; int j = 0;
        List<Integer> list = new ArrayList<>();


        for(int i=0;i<S.length();i++){

            //Update the last index if we found any new last.
            int lastindex = last[S.charAt(i)-'a'];
            j = Math.max(j,lastindex);

            //If we reach the last index dump the size into our arraylist/
            if(i==j){
                list.add(i-start+1);
                start = i+1;
            }
        }

        return list;
    }
}