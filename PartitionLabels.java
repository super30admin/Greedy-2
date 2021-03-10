/*
we use 2 pointers here.
for each char in string, we will record its last occurenece index

then start iterating the string from index 0
for each char get the last location and keep a ptr thr

continue this until i == ptr
    once equal, then partition has been achieved
    record the length of partintion
    and start from index i+1
    
time complexity: O(n)
space complexity :O(1)
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        
        //edge case or base case
        if(S.length() == 0 || S == null)return new ArrayList<>();
        
        List<Integer> result = new ArrayList<>();
        
        //record last occurence of each char
        int[]lastOccurenceRecord = new int[26];
        for(int i = 0;i < S.length();i++){
            lastOccurenceRecord[S.charAt(i)-'a'] = i;
        }
        
        int ptr1 = 0;
        int ptr2 = 0;
        for(int i = 0; i < S.length();i++){
            ptr2 = Math.max(ptr2, lastOccurenceRecord[S.charAt(i)-'a']);
            if(i == ptr2){
                result.add(ptr2 - ptr1 +1);
                ptr1 = i+1;
            }
        }
        return result;
    }
}


/*
"ababcbaca defegdehijhklij"
         8
        
*/