#// Time Complexity : O(N^2) 
# // Space Complexity : O(N) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort( key = lambda x: (-x[0],x[1]) )
        result = []
        for i in people:
            result.insert(i[1],i)
        return result

# Approach:
# 1. Sort the people based on their heights in descending order. If two people have the same height
# then sort them based on their original order in the queue.
# 2. Iterate over the sorted people and insert each person at the correct position in the result list.
# 3. Return the result list.
