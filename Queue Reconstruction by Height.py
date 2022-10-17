# TC: (O(n log n) + n^2) = O(n^2)
# SC : O(1)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key = lambda x: (-x[0], x[1])) # n logn
        ans = [] 
        for i in range(len(people)): # O(n)
            ans.insert(people[i][1],people[i]) # Insert takes O(n)
        return ans