'''
Time Complexity: O(n^2)
Space Complexity: O(n)

Approach: 
1. Sort the people based on their height in descending order and their position in ascending order.
2. Insert the people into the queue based on their position.
3. Return the queue.
'''

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        sortedPeopleBasedOnHeight = sorted(people, key=lambda x: (-x[0], x[1]))
        print(sortedPeopleBasedOnHeight)

        queue = []

        for i in range(len(sortedPeopleBasedOnHeight)):
            queue.insert(sortedPeopleBasedOnHeight[i][1],sortedPeopleBasedOnHeight[i])
        
        return queue
            