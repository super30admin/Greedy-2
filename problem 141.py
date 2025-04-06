#  https://leetcode.com/problems/queue-reconstruction-by-height/

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key = lambda x: (-x[0],x[1])) # O(n logn)

        queue = []
        for person in people: 
            queue.insert(person[1],person) # n for insertion and for n elements
            # O(n^2)
        
        return queue

# TC: O(n^2) overall
# SC: O(n)