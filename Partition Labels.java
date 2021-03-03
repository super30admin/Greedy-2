/*
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        if S is None or len(S) == 0:
            return []
        
        last_index = dict()
        for i in range(len(S)):
            last_index[S[i]] = i
        
        start = 0
        end = 0
        answer = []
        for i in range(len(S)):
            end = max(end, last_index[S[i]])
            if i == end:
                answer.append(end-start+1)
                start = i+1
        return answer
*/
// time - O(n)
// space - O(1) as hashmap only contains lower case alphabets which are 26 in total
// logic - maintained a hashmap which recorded last index of each element and then I maintained strt and end pointer to record partition
class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0)
            return new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            map.put(c, i);
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            end = Math.max(end, map.get(c));
            
            if (i == end){
                ans.add(end-start+1);
                start = i+1;
            }
        }
        return ans;
            
    }
}