//Time : O(n)
//Space:O(1)
//leetCode : Yes
//Approach:
//1.From the given string , find last occurence of each character and store the value.
//2.Now start from the first index and check each character's last index and update end to this value.
//3.While traversing each character, if we reach end index then we can add this substring(start,end) length to list.
//4.Now update start to end's next value.Do this till end of string.
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        int[] lastIndex = new int[26];
        for(int i = 0;i<S.length();i++)
            lastIndex[S.charAt(i)-'a'] = i;
        for(int i = 0;i<S.length();i++){
            end = Math.max(end,lastIndex[S.charAt(i)-'a']);
            if(i == end){
                result.add(end-start+1);
                start = end+1;
            }
        }
        return result;
    }
}
