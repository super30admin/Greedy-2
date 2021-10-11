class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key = lambda x: [-x[0], x[1]])
        ans = []
        for h, k in people:
            ans = ans[:k] + [[h, k]] + ans[k:]
        return ans

%TC:O(n)
%SC:O(n)