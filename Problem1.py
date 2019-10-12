class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
    	# Time Complexity : O(n^2) because for every person we are inserting the node in the array at a position.
    	# Space Complexity : O(1) if we don't consider the size of the resultant array for the space complexity
        people = sorted(people, key = lambda x: (-x[0],x[1]))
        res = []
        for i in people:
            res.insert(i[1], i)
        return res