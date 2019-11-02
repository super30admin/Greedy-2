# Time Complexity: O (n^2)(Where n is length of input) 
# Space Complexity: O(1) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# greedy approach can be used here

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
#       We will sort the array by descending order of height and ascending order of k.
        people.sort(key = lambda x : (-x[0], x[1]))
        
        ans = []
        
#       For each pair in sorted list add it to the answer at index k
        for person in people:
            ans.insert(person[1], person)
            
        return ans
